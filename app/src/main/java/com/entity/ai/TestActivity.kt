package com.entity.ai

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class TestActivity : ComponentActivity() {
    private val TAG = "TestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntityAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TestScreen()
                }
            }
        }
    }
}

@Composable
fun TestScreen(viewModel: MainViewModel = viewModel()) {
    var testResults by remember { mutableStateOf<List<String>>(emptyList()) }
    var isTesting by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AWS Configuration Test",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                isTesting = true
                testResults = emptyList()
                // The test will run automatically through MainViewModel's init block
            },
            enabled = !isTesting,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(if (isTesting) "Testing..." else "Run AWS Tests")
        }

        // Display test results
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                viewModel.chatHistory.forEach { message ->
                    Text(
                        text = message.content,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
} 