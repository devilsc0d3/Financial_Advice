package com.example.financial_advice.app.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.financial_advice.app.core.Screens


@Composable
fun SettingContent(navController: NavHostController) {
    Column (
        Modifier
            .background(color = Color(31, 31, 31))
            .height(800.dp)
    ){
        Header(navController, "Settings")

        Title("General")
        Widget("Language", Color.White) {}
        Widget("Theme", Color.White) {}

        Title("data")
        Widget("share", Color.White) {}
        Widget("import", Color.White) {}
        Widget("export", Color.White) {}
        Widget("Clear cache", Color.Red) {}

        Title("Assistance")
        Widget("parent", Color.White) {}
        Widget("contact", Color.White) {}
        Widget("CGU", Color.White) {}

    }

}


@Composable
fun Widget(txt : String, color: Color, onClick: () -> Unit) {
    Row (
        Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 10.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = txt,
            fontWeight = FontWeight.W600,
            fontSize = 23.sp,
            color = color

        )
        Text(
            text = "  >",
            fontWeight = FontWeight.W600,
            fontSize = 25.sp,
            color = color
        )
    }
}

@Composable
fun Title(txt : String) {
    Row (
        Modifier
            .padding(12.dp)
    ) {
        Text(
            text = txt,
            fontWeight = FontWeight.W800,
            fontSize = 28.sp,
            color = Color.White
        )
    }
}

@Composable
fun Header(navController: NavHostController, txt: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(Color(41, 41, 41, 255))
            .fillMaxWidth()
            .height(70.dp)

    ) {
        Text(
            text = txt,
            color = Color.White,
            fontWeight = FontWeight.W800,
            fontSize = 25.sp,
            modifier = Modifier.padding(15.dp,0.dp)
        )
        Text(
            text = "home",
            color = Color.White,
            fontWeight = FontWeight.W800,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .clickable {
                    navController.navigate(Screens.Home.route)
                }
        )
    }
}

