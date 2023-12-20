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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.financial_advice.R


@Composable
fun SettingContent(navHostController: NavHostController) {
    Column (
        Modifier
            .background(color = Color(255, 255, 255, 255))
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        val context = LocalContext.current

        Title(stringResource(id = R.string.General))
        Widget(stringResource(id = R.string.Language), Color.Black) {
            navHostController.navigate("language") }
        Widget(stringResource(id = R.string.Theme), Color.Black) {
            navHostController.navigate("theme") }
        Title(stringResource(id = R.string.Data))
        Widget(stringResource(id = R.string.share), Color.Black,onClick = {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "For a better manager of account, Download Financial_Advice by L.F ! ...")
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(sendIntent, "Share via"))
        })
        Widget(stringResource(id = R.string.importcsv), Color.Black) {}
        Widget(stringResource(id = R.string.exportcsv), Color.Black) {}
        Widget(stringResource(id = R.string.clear), Color.Red) {}

        Title(stringResource(id = R.string.help))
        Widget(stringResource(id = R.string.ctrl), Color.Black) {}
        Widget(stringResource(id = R.string.contact), Color.Black) {}
        Widget(stringResource(id = R.string.about), Color.Black) { navHostController.navigate("cgu") }
    }
}
