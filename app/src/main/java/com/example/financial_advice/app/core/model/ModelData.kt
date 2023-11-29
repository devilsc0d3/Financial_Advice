package com.example.financial_advice.app.core.model

import android.text.format.DateFormat
import androidx.compose.ui.graphics.Color

data class ModelData  (
    var money : Int,
    var description : String? = null,
    var color : Color? = null,
    var data: DateFormat? = null,
)