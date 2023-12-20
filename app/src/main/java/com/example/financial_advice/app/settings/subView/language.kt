package com.example.financial_advice.app.settings.subView

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.util.Locale

@Composable
fun Language(navHostController: NavHostController) {
    Column (
        Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        val context = LocalContext.current

        LanguageOption("Français", Color.Black) {
            updateLocale(context, "fr")
            navHostController.navigate("settings")
        }

        LanguageOption("English", Color.Black) {
            updateLocale(context, "en")
            navHostController.navigate("settings")
        }

LanguageOption("Español", Color.Black) {
            updateLocale(context, "es")
            navHostController.navigate("settings")
        }

LanguageOption("Deutsch", Color.Black) {
            updateLocale(context, "de")
            navHostController.navigate("settings")
        }

LanguageOption("Italiano", Color.Black) {
            updateLocale(context, "it")
            navHostController.navigate("settings")
        }

LanguageOption("Português", Color.Black) {
            updateLocale(context, "pt")
            navHostController.navigate("settings")
        }

    LanguageOption("Polskie", Color.Black) {
            updateLocale(context, "pl")
            navHostController.navigate("settings")
        }

    LanguageOption("Nederlands", Color.Black) {
            updateLocale(context, "nl")
            navHostController.navigate("settings")
        }

    LanguageOption("Русский", Color.Black) {
            updateLocale(context, "ru")
            navHostController.navigate("settings")
        }

    LanguageOption("Čeština", Color.Black) {
            updateLocale(context, "cs")
            navHostController.navigate("settings")
        }

    LanguageOption("Slovenský", Color.Black) {
            updateLocale(context, "sk")
            navHostController.navigate("settings")
        }

    }
}

@Composable
fun LanguageOption(text: String, color: Color, onClick: () -> Unit) {
    Row (
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
            color = color
        )
        Text(
            text = "  >",
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            color = color
        )
    }
}

fun updateLocale(context: Context, languageCode: String) {
    val currentLocale = context.resources.configuration.locale
    val newLocale = Locale(languageCode)
    if (currentLocale != newLocale) {
        Locale.setDefault(newLocale)
        val config = context.resources.configuration
        config.setLocale(newLocale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}
