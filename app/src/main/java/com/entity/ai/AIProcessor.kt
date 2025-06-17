package com.entity.ai

import android.content.Context
import com.google.mlkit.language.smartreply.SmartReply
import com.google.mlkit.language.smartreply.TextMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class AIProcessor(private val context: Context) {
    private val smartReply = SmartReply.getClient()
    private val conversationHistory = mutableListOf<TextMessage>()

    suspend fun processInput(input: String): String = withContext(Dispatchers.IO) {
        // Add user message to conversation history
        val userMessage = TextMessage.createForRemoteUser(
            input,
            System.currentTimeMillis(),
            "user"
        )
        conversationHistory.add(userMessage)

        // Get AI suggestions
        val suggestions = getSuggestions()

        // Process and return response
        return@withContext suggestions.firstOrNull()?.text ?: "I'm still learning..."
    }

    private suspend fun getSuggestions(): List<TextMessage> = withContext(Dispatchers.IO) {
        try {
            val result = smartReply.suggestReplies(conversationHistory).await()
            return@withContext result.suggestions.map { suggestion ->
                TextMessage.createForLocalUser(
                    suggestion.text,
                    System.currentTimeMillis()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return@withContext emptyList()
        }
    }

    fun clearHistory() {
        conversationHistory.clear()
    }
} 