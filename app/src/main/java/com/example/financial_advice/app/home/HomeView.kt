package com.example.financial_advice.app.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financial_advice.app.mainData2
import com.example.financial_advice.app.money


@Composable
fun HomeContent() {
    var showDialog by remember { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(255, 255, 255, 255))
    ) {
        Diagram(1200f, money)
        ButtonAdd { showDialog = true }
        for (data in mainData2) {
            Message(data.money.toString(), data.category, Color.White, 15.sp, FontWeight.W400) {}
        }
        if (showDialog) { AlertDialogTest(onDismiss = { showDialog = false }) }
        Spacer(modifier = Modifier.padding(0.dp, 35.dp))
    }
}


