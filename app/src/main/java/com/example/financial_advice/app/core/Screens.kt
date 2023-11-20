package com.example.financial_advice.app.core

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Settings : Screens("settings")
}