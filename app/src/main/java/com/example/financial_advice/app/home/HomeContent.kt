package com.example.financial_advice.app.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financial_advice.app.messages
import com.example.financial_advice.app.money
import com.example.financial_advice.app.namesList

@Composable
fun Message(txt: String, category: String, color: Color, size: TextUnit, weight: FontWeight, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(Color(41, 41, 41, 255))
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick() }

    ) {
        Text(
            text = "$txt €",
            color = color,
            fontSize = size,
            fontWeight = weight,
            modifier = Modifier.padding(15.dp),
        )

        Text(
            text = category,
            color = color,
            fontSize = size,
            fontWeight = weight,
            modifier = Modifier.padding(15.dp),
        )
    }
}

@Composable
fun ButtonAdd(onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(0.dp, 50.dp),
        colors = ButtonDefaults.buttonColors(Color(24, 91, 100, 255))
    ) {
        Text(
            text = "+",
            modifier = Modifier
                .padding(50.dp, 5.dp)
                .background(Color.Transparent)
        )
    }
}

@Composable
fun PieChart(data: List<Float>, colors: List<Color>) {
    Box(
        modifier = Modifier
            .size(300.dp)
            .padding(70.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = java.lang.Float.min(centerX, centerY)
            var startAngle = 0f

            val total = data.sum()

            data.forEachIndexed { index, value ->
                val sweepAngle = 360 * (value / total)
                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = true,
                    topLeft = Offset(centerX - radius, centerY - radius),
                    size = Size(radius * 2, radius * 2)
                )
                startAngle += sweepAngle
                drawCircle(
                    color = Color(255, 255, 255, 255),
                    radius = radius / 1.2f,
                    center = Offset(centerX, centerY)
                )
            }
        }

        Text(
            text = money.toString(),
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogTest(onDismiss: () -> Unit) {
    val openDialog = remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("0") }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onDismiss()
            },
            title = {
                Text(text = "enter value")
            },
            text = {
                Column {
                    TextField(
                        value = text,
                        onValueChange = { text = it }
                    )
                }
            },
            confirmButton = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            openDialog.value = false

                            if (text != "0") {
                                namesList.add(text)
                                money -= text.toInt()
                                messages = namesList.toTypedArray().plus(messages).toList().toTypedArray()
                                namesList.clear()
                            }
                            onDismiss()
                        }
                    ) {
                        Text("Add")
                    }
                }
            }
        )
    }
}