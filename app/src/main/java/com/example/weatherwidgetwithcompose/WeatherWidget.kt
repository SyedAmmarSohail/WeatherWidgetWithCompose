package com.example.weatherwidgetwithcompose

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import java.util.Random

object WeatherWidget : GlanceAppWidget() {
    val temperatureKey = stringPreferencesKey("temperature")
    val weatherDescriptionKey = stringPreferencesKey("weatherDescription")

    @Composable
    override fun Content() {
        // Retrieve temperature and weather description from DataStore
        val temperature = currentState(key = temperatureKey) ?: "25"
        val weatherDescription = currentState(key = weatherDescriptionKey) ?: "Partly Cloudy"

        Column(
            modifier = GlanceModifier.fillMaxSize(),
            verticalAlignment = Alignment.Vertical.CenterVertically,
            horizontalAlignment = Alignment.Horizontal.CenterHorizontally
        ) {
            WeatherInfo(
                temperature = temperature,
                weatherDescription = weatherDescription,
                onClick = actionRunCallback(UpdateWeatherActionCallback::class.java)
            )
        }
    }
}

class WeatherWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = WeatherWidget
}

class UpdateWeatherActionCallback : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        val random = Random()
        val temperature = "${random.nextInt(40)}°C"
        val weatherDescriptions = listOf(
            "Sunny", "Partly Cloudy", "Cloudy", "Rainy", "Thunderstorms"
        )
        val weatherDescription = weatherDescriptions[random.nextInt(weatherDescriptions.size)]

        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[WeatherWidget.temperatureKey] = temperature
            prefs[WeatherWidget.weatherDescriptionKey] = weatherDescription
        }
        WeatherWidget.update(context, glanceId)
    }
}