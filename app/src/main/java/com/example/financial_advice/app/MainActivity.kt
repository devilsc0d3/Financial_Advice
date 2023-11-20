package com.example.financial_advice.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financial_advice.app.core.Screens
import com.example.financial_advice.app.home.HomeContent
import com.example.financial_advice.app.settings.SettingContent
import com.example.financial_advice.ui.theme.Financial_AdviceTheme


var money = 1200
val names = arrayOf<String>()
val namesList = names.toMutableList()
var messages = arrayOf<String>()


class MainActivity : ComponentActivity() {
    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Financial_AdviceTheme {
                App()
            }
        }
    }
}
@Composable
private fun App() {
    val navController = rememberNavController()
    NavigationManagement(navController)
}

@Composable
private fun NavigationManagement(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeContent(navController)
        }
        composable(route = Screens.Settings.route) {
            SettingContent(navController)
        }
    }
}
