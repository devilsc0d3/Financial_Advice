package com.example.financial_advice.app.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun settingContent() {
    Column (
        Modifier
            .background(color = Color(31, 31, 31))
            .height(800.dp)
    ){
        Header("Settings")

        Title("General")
        widget("Language", Color.White) {}
        widget("Theme", Color.White) {}

        Title("data")
        widget("share", Color.White) {}
        widget("import", Color.White) {}
        widget("export", Color.White) {}
        widget("Clear cache", Color.Red) {}

        Title("Assistance")
        widget("parent", Color.White) {}
        widget("contact", Color.White) {}
        widget("CGU", Color.White) {}

    }

}


@Composable
fun widget(txt : String, color: Color, onClick: () -> Unit) {

    Row (
        Modifier
            .clickable { onClick() }
            .width(500.dp)
            .padding(start = 15.dp, end = 21.dp, bottom = 6.5.dp, top = 6.5.dp),
        verticalAlignment = Alignment.CenterVertically
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
            fontSize = 23.sp,
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
fun Header(txt: String) {
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
    }
}

