package com.example.financial_advice.app.core.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.financial_advice.app.core.model.Screens

@Composable
fun Footer(navController: NavHostController, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .background(Color(24, 91, 100, 255))
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = "data",
            color = Color.White,
            fontWeight = FontWeight.W800,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .clickable {
                    Log.d("Navigation", "Navigating to Home")
                    navController.navigate(Screens.Data.route)
                    onClick()
                }
        )
        Text(
            text = "settings",
            color = Color.White,
            fontWeight = FontWeight.W800,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .clickable {
                    Log.d("Navigation", "Navigating to Settings")
                    navController.navigate(Screens.Home.route)
                }
        )
        Text(
            text = "settings",
            color = Color.White,
            fontWeight = FontWeight.W800,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .clickable {
                    Log.d("Navigation", "Navigating to Settings")
                    navController.navigate(Screens.Settings.route)
                }
        )
    }
}