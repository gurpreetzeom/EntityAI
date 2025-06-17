package com.entity.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntityAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    var userInput by remember { mutableStateOf("") }
    var isProcessing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Entity AI",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Chat history
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                viewModel.chatHistory.forEach { message ->
                    ChatMessage(message)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        // Input area
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = userInput,
                onValueChange = { userInput = it },
                label = { Text("Type your message") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                enabled = !isProcessing
            )

            Button(
                onClick = {
                    if (userInput.isNotBlank()) {
                        isProcessing = true
                        viewModel.processInput(userInput) {
                            isProcessing = false
                            userInput = ""
                        }
                    }
                },
                enabled = !isProcessing && userInput.isNotBlank()
            ) {
                Text(if (isProcessing) "Processing..." else "Send")
            }
        }
    }
}

@Composable
fun ChatMessage(message: ChatMessage) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = if (message.isFromUser) 
            MaterialTheme.colors.primary.copy(alpha = 0.1f)
        else 
            MaterialTheme.colors.surface
    ) {
        Text(
            text = message.content,
            modifier = Modifier.padding(16.dp)
        )
    }
}

data class ChatMessage(
    val content: String,
    val isFromUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
) 