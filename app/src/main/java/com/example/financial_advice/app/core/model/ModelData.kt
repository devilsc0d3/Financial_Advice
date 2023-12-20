package com.example.financial_advice.app.core.model

import android.text.format.DateFormat
import androidx.compose.ui.graphics.Color

data class ModelData  (
    var money : Float,
    var category: String,
    var description : String? = null,
    var color : Color? = null,
    var data: DateFormat? = null,
)