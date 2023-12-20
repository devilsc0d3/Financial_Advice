package com.example.financial_advice.app.settings.subView

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.financial_advice.app.core.ui.theme.DarkColorScheme
import com.example.financial_advice.app.core.ui.theme.LightColorScheme
import com.example.financial_advice.app.core.ui.theme.Typography

@Composable
fun Theme(navHostController: NavHostController) {
    var selectedTheme by remember { mutableStateOf(LightColorScheme) }

    Column(
        Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ThemeOption("Light") {
            selectedTheme = LightColorScheme
            navHostController.navigate("home")
        }
        ThemeOption("Dark") {
            selectedTheme = DarkColorScheme
            navHostController.navigate("home")
        }

        // Pass the selected theme to updateMaterialTheme
        UpdateMaterialTheme(selectedTheme) {
            // Content of your app goes here
        }
    }
}

@Composable
fun UpdateMaterialTheme(colorScheme: ColorScheme, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun ThemeOption(text: String, onClick: () -> Unit) {
    Row(
        Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.W600,
            fontSize = 15.sp,
            color = Color(24, 91, 100, 255)
        )
        Text(
            text = "  >",
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            color = Color(24, 91, 100, 255)
        )
    }
}
