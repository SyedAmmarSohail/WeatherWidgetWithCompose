package com.example.weatherwidgetwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherwidgetwithcompose.ui.theme.WeatherWidgetWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherWidgetWithComposeTheme {
            }
        }
    }
}