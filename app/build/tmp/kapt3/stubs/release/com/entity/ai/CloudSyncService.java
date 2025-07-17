package com.entity.ai;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J#\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00190\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010 \u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/entity/ai/CloudSyncService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "credentialsProvider", "Lcom/amazonaws/auth/CognitoCachingCredentialsProvider;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "s3Client", "Lcom/amazonaws/services/s3/AmazonS3Client;", "transferUtility", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferUtility;", "kotlin.jvm.PlatformType", "downloadFromS3", "", "key", "file", "Ljava/io/File;", "syncFromCloud", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncToCloud", "data", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testAWSConfiguration", "", "uploadToS3", "Companion", "app_release"})
public final class CloudSyncService {
    private final android.content.Context context = null;
    private final java.lang.String TAG = "CloudSyncService";
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull
    public static final com.entity.ai.CloudSyncService.Companion Companion = null;
    private static final java.lang.String IDENTITY_POOL_ID = "ap-south-1:e6f17899-4f76-41d4-ba22-e2f4441d3057";
    private static final com.amazonaws.regions.Regions REGION = com.amazonaws.regions.Regions.AP_SOUTH_1;
    private static final java.lang.String S3_BUCKET_NAME = "ai-companion-data";
    private static final java.lang.String USER_POOL_ID = "ap-south-1_aSe55VYhN";
    private static final java.lang.String APP_CLIENT_ID = "4f133r8vbbh4tg7i4v1ep2qe1i";
    private final com.amazonaws.auth.CognitoCachingCredentialsProvider credentialsProvider = null;
    private final com.amazonaws.services.s3.AmazonS3Client s3Client = null;
    private final com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility transferUtility = null;
    
    public CloudSyncService(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object testAWSConfiguration(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object syncToCloud(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object syncFromCloud(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>>> continuation) {
        return null;
    }
    
    public final void uploadToS3(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    public final void downloadFromS3(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.io.File file) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0014\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/entity/ai/CloudSyncService$Companion;", "", "()V", "APP_CLIENT_ID", "", "IDENTITY_POOL_ID", "REGION", "Lcom/amazonaws/regions/Regions;", "S3_BUCKET_NAME", "USER_POOL_ID", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}