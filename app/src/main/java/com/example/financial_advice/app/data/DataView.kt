package com.example.financial_advice.app.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DataContent(navController: NavHostController) {
    Column(
        Modifier
            .background(color = Color(255, 255, 255, 255))
            .height(800.dp)
    ) {
        DataEmpty()
    }
}


