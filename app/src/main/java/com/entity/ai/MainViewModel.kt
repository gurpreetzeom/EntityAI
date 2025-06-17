package com.entity.ai

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "MainViewModel"
    private val aiProcessor = AIProcessor(application)
    private val cloudSync = CloudSyncService(application)

    private val _chatHistory = MutableStateFlow<List<ChatMessage>>(emptyList())
    val chatHistory: StateFlow<List<ChatMessage>> = _chatHistory

    init {
        // Test AWS configuration on startup
        testAWSConfiguration()
    }

    private fun testAWSConfiguration() {
        viewModelScope.launch {
            try {
                val isConfigured = cloudSync.testAWSConfiguration()
                if (isConfigured) {
                    Log.i(TAG, "AWS Configuration test passed successfully")
                    // Add success message to chat
                    _chatHistory.value = _chatHistory.value + ChatMessage(
                        "AWS Configuration verified successfully!",
                        false
                    )
                } else {
                    Log.e(TAG, "AWS Configuration test failed")
                    // Add error message to chat
                    _chatHistory.value = _chatHistory.value + ChatMessage(
                        "AWS Configuration test failed. Please check the logs.",
                        false
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error testing AWS configuration: ${e.message}")
                e.printStackTrace()
                // Add error message to chat
                _chatHistory.value = _chatHistory.value + ChatMessage(
                    "Error testing AWS configuration: ${e.message}",
                    false
                )
            }
        }
    }

    fun processInput(input: String, onComplete: () -> Unit) {
        viewModelScope.launch {
            // Add user message to chat
            val userMessage = ChatMessage(input, true)
            _chatHistory.value = _chatHistory.value + userMessage

            try {
                // Process with AI
                val response = aiProcessor.processInput(input)
                
                // Add AI response to chat
                val aiMessage = ChatMessage(response, false)
                _chatHistory.value = _chatHistory.value + aiMessage

                // Sync to cloud
                cloudSync.syncToCloud(mapOf(
                    "userInput" to input,
                    "aiResponse" to response,
                    "timestamp" to System.currentTimeMillis()
                ))
            } catch (e: Exception) {
                // Add error message to chat
                val errorMessage = ChatMessage(
                    "Sorry, I encountered an error. Please try again.",
                    false
                )
                _chatHistory.value = _chatHistory.value + errorMessage
            }

            onComplete()
        }
    }

    fun loadChatHistory() {
        viewModelScope.launch {
            try {
                val history = cloudSync.syncFromCloud()
                _chatHistory.value = history.map { data ->
                    ChatMessage(
                        content = data["aiResponse"] as? String ?: "",
                        isFromUser = false,
                        timestamp = data["timestamp"] as? Long ?: System.currentTimeMillis()
                    )
                }
            } catch (e: Exception) {
                // Handle error silently
            }
        }
    }
} 