package com.example.financial_advice.app.core.model

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Settings : Screens("settings")
    object Data : Screens("data")
}