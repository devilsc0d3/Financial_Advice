package com.example.financial_advice.app.core.model

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Settings : Screens("settings")

    object Cgu : Screens("cgu")

    object Language : Screens("language")

    object Theme : Screens("theme")
    object Data : Screens("data")
}