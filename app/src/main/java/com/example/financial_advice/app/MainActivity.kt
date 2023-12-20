package com.example.financial_advice.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financial_advice.app.core.model.ModelData
import com.example.financial_advice.app.core.model.Screens
import com.example.financial_advice.app.core.ui.Footer
import com.example.financial_advice.app.core.ui.Header
import com.example.financial_advice.app.data.DataContent
import com.example.financial_advice.app.home.HomeContent
import com.example.financial_advice.app.settings.SettingContent
import com.example.financial_advice.app.core.ui.theme.Financial_AdviceTheme
import com.example.financial_advice.app.settings.subView.CguContent
import com.example.financial_advice.app.settings.subView.Language
import com.example.financial_advice.app.settings.subView.Theme


var money = 1200f
val mainData2 = mutableListOf<ModelData>()
val suggestions = listOf("restoration", "alcohol", "transport", "shopping", "home", "health", "entertainment", "other")

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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Header(navController = navController) {}
        },
        content =  {
            Box(Modifier.padding(top = it.calculateTopPadding())) {
                NavigationManagement(navController)
            }
        },
        bottomBar = {
            Footer(navController) {}
        },
    )
}

@Composable
private fun NavigationManagement(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeContent()
        }
        composable(route = Screens.Settings.route) {
            SettingContent(navController)
        }
        composable(route = Screens.Data.route) {
            DataContent()
        }
        composable(route = Screens.Cgu.route) {
            CguContent()
        }
        composable(route = Screens.Theme.route) {
            Theme(navController)
        }
        composable(route = Screens.Language.route) {
            Language(navController)
        }
    }
}
