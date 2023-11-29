package com.example.financial_advice.app.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@Composable
fun Title(txt : String) {
    Row (
        Modifier
            .padding(12.dp)
    ) {
        Text(
            text = txt,
            fontWeight = FontWeight.W800,
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}