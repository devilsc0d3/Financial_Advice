package com.example.financial_advice.app.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.financial_advice.R

@Composable
fun DataEmpty() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement  = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.data_empty1),
            contentDescription = null,
            modifier = Modifier.run {
                fillMaxWidth()
            }
        )
    }
}