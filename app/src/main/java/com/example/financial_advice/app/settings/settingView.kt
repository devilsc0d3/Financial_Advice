package com.example.financial_advice.app.settings

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController


@Composable
fun SettingContent(navHostController: NavHostController) {
    Column (
        Modifier
            .background(color = Color(255, 255, 255, 255))
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        val context = LocalContext.current

        Title("General")
        Widget("Language", Color.Black) {}
        Widget("Theme", Color.Black) {}

        Title("data")
        Widget("share", Color.Black,onClick = {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "For a better manager of account, Download Financial_Advice by L.F ! ...")
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(sendIntent, "Share via"))
        })
        Widget("import", Color.Black) {}
        Widget("export", Color.Black) {}
        Widget("Clear cache", Color.Red) {}

        Title("Assistance")
        Widget("parent", Color.Black) {}
        Widget("contact", Color.Black) {}
        Widget("CGU", Color.Black) { navHostController.navigate("cgu") }
    }

}
