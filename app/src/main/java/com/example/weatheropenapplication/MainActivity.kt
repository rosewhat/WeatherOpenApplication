package com.example.weatheropenapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatheropenapplication.screens.Navigation
import com.example.weatheropenapplication.ui.theme.WeatherOpenApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherOpenApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

