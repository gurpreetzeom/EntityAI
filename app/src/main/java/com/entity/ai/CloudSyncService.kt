package com.entity.ai

import android.content.Context
import android.util.Log
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3Client
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.io.File

class CloudSyncService(private val context: Context) {
    private val TAG = "CloudSyncService"
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    
    // AWS Configuration
    companion object {
        private const val IDENTITY_POOL_ID = "ap-south-1:e6f17899-4f76-41d4-ba22-e2f4441d3057"
        private const val REGION = Regions.AP_SOUTH_1
        private const val S3_BUCKET_NAME = "ai-companion-data"
        private const val USER_POOL_ID = "ap-south-1_aSe55VYhN"
        private const val APP_CLIENT_ID = "4f133r8vbbh4tg7i4v1ep2qe1i"
    }
    
    private val credentialsProvider = CognitoCachingCredentialsProvider(
        context,
        IDENTITY_POOL_ID,
        REGION
    )
    
    private val s3Client = AmazonS3Client(credentialsProvider)
    private val transferUtility = TransferUtility.builder()
        .s3Client(s3Client)
        .context(context)
        .build()

    // Test function to verify AWS configuration
    suspend fun testAWSConfiguration(): Boolean {
        return try {
            // Test 1: Verify Identity Pool credentials
            val credentials = credentialsProvider.credentials
            Log.d(TAG, "Identity Pool credentials obtained successfully")
            
            // Test 2: Verify S3 bucket access
            val bucketExists = s3Client.doesBucketExistV2(S3_BUCKET_NAME)
            if (!bucketExists) {
                Log.e(TAG, "S3 bucket does not exist: $S3_BUCKET_NAME")
                return false
            }
            Log.d(TAG, "S3 bucket access verified: $S3_BUCKET_NAME")
            
            // Test 3: Verify Firestore connection
            val testDoc = firestore.collection("test")
                .document("connection_test")
                .set(mapOf("timestamp" to System.currentTimeMillis()))
                .await()
            Log.d(TAG, "Firestore connection verified")
            
            // Test 4: Verify Firebase Auth
            val currentUser = auth.currentUser
            Log.d(TAG, "Firebase Auth status: ${if (currentUser != null) "User logged in" else "No user logged in"}")
            
            true
        } catch (e: Exception) {
            Log.e(TAG, "AWS Configuration test failed: ${e.message}")
            e.printStackTrace()
            false
        }
    }

    suspend fun syncToCloud(data: Map<String, Any>) {
        try {
            val userId = auth.currentUser?.uid ?: return
            firestore.collection("users")
                .document(userId)
                .collection("data")
                .add(data)
                .await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun syncFromCloud(): List<Map<String, Any>> {
        return try {
            val userId = auth.currentUser?.uid ?: return emptyList()
            val snapshot = firestore.collection("users")
                .document(userId)
                .collection("data")
                .get()
                .await()
            
            snapshot.documents.mapNotNull { it.data }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun uploadToS3(file: File, key: String) {
        transferUtility.upload(
            S3_BUCKET_NAME,
            key,
            file
        )
    }

    fun downloadFromS3(key: String, file: File) {
        transferUtility.download(
            S3_BUCKET_NAME,
            key,
            file
        )
    }
} 