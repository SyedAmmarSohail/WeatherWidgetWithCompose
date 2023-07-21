package com.example.weatherwidgetwithcompose

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.action.Action
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.height
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.ImageProvider
import androidx.glance.layout.size
import androidx.glance.unit.ColorProvider

@Composable
fun WeatherInfo(
    temperature: String,
    weatherDescription: String,
    onClick: Action
) {
    Column(
        horizontalAlignment = Alignment.Horizontal.CenterHorizontally
    ) {
        Image(provider = ImageProvider(R.drawable.cloud), contentDescription = "cloudImage", modifier = GlanceModifier.size(50.dp))
        Text(
            text = temperature,
            style = TextStyle(fontSize = 28.sp, color = ColorProvider(Color.DarkGray)),
        )
        Spacer(modifier = GlanceModifier.height(4.dp))
        Text(
            text = weatherDescription,
            style = TextStyle(fontSize = 16.sp, color = ColorProvider(Color.DarkGray)),
        )
        Spacer(modifier = GlanceModifier.height(4.dp))
        Button(text = "Update", onClick = onClick)
    }
}
