package com.example.financial_advice.app.settings.subView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financial_advice.R

@Composable
fun CguContent() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(255, 255, 255, 255))
    ) {
        Title1(txt = stringResource(R.string.cgu_title))
        Title(txt = stringResource(R.string.cgu_intro_title))
        TextPart(txt = stringResource(R.string.cgu_intro_content))
        Title(txt = stringResource(R.string.cgu_usage_title))
        TextPart(txt = stringResource(R.string.cgu_usage_content))
        Title(txt = stringResource(R.string.cgu_customization_title))
        TextPart(txt = stringResource(R.string.cgu_customization_content))
        Title(txt = stringResource(R.string.cgu_data_collection_title))
        TextPart(txt = stringResource(R.string.cgu_data_collection_content))
        Title(txt = stringResource(R.string.cgu_security_title))
        TextPart(txt = stringResource(R.string.cgu_security_content))
        Title(txt = stringResource(R.string.cgu_updates_title))
        TextPart(txt = stringResource(R.string.cgu_updates_content))
        Title(txt = stringResource(R.string.cgu_responsibilities_title))
        TextPart(txt = stringResource(R.string.cgu_responsibilities_content))
        Title(txt = stringResource(R.string.cgu_changes_title))
        TextPart(txt = stringResource(R.string.cgu_changes_content))
        Title(txt = stringResource(R.string.cgu_contact_title))
        TextPart(txt = stringResource(R.string.cgu_contact_content))
        TextPart(txt = stringResource(R.string.cgu_last_update))
        Spacer(modifier = Modifier.padding(0.dp, 40.dp))
    }
}


@Composable
fun Title1(txt: String) {
    Text(
        text = txt,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = Color(24, 91, 100, 255),
        modifier = Modifier
            .padding(0.dp, 20.dp)
    )
}

@Composable
fun Title(txt: String) {
    Text(
        text = txt,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(20.dp, 5.dp)
    )
}

@Composable
fun TextPart(txt: String) {
    Text(
        text = txt,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(50.dp, 5.dp)
    )
}

