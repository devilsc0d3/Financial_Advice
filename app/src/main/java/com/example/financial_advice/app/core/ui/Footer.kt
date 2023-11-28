package com.example.financial_advice.app.core.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.financial_advice.R
import com.example.financial_advice.app.core.model.Screens

@Composable
fun Footer(navController: NavHostController, onClick: () -> Unit) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .background(Color(24, 91, 100, 255))
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Icon(
            painter = if(currentDestination?.hierarchy?.any { it.route == "data"} == true) {
                painterResource(R.drawable.data_fill)
            } else {
                painterResource(R.drawable.data)
            },
            contentDescription = "data button",
            tint = Color.White,
            modifier = Modifier
                .height(50.dp)
                .padding(15.dp, 0.dp)
                .clickable {
                    Log.d("Navigation", "Navigating to Data")
                    navController.navigate(Screens.Data.route)
                    onClick()
                }
        )
        Icon(
            painter = if(currentDestination?.hierarchy?.any { it.route == "home"} == true) {
                painterResource(R.drawable.home_fill)
            } else {
                painterResource(R.drawable.home)
            },            contentDescription = "home button",
            tint = Color.White,
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .height(50.dp)
                .clickable {
                    Log.d("Navigation", "Navigating to home")
                    navController.navigate(Screens.Home.route)
                }
        )
        Icon(
            painter = if(currentDestination?.hierarchy?.any { it.route == "settings"} == true) {
                painterResource(R.drawable.setting_fill)
            } else {
                painterResource(R.drawable.setting)
            },            contentDescription = "setting button",
            tint = Color.White,
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .height(50.dp)
                .clickable {
                    Log.d("Navigation", "Navigating to Settings")
                    navController.navigate(Screens.Settings.route)
                }
        )
    }
}