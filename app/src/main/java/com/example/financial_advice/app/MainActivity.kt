package com.example.financial_advice.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.financial_advice.ui.theme.Financial_AdviceTheme
import java.lang.Float.min

var money = 1200
val names = arrayOf<String>()
val namesList = names.toMutableList()
var messages = arrayOf<String>()
class MainActivity : ComponentActivity() {

    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Financial_AdviceTheme {
                var showDialog by remember { mutableStateOf(false) } // Nouvel état

                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .background(color = Color(31, 31, 31))
                ) {

                    Header("Financial_Advice")

                    PieChart(
                        data = listOf(20f, 30f, 50f),
                        colors = listOf(
                            Color.hsl(hue = 0.1F, saturation = 0.3F, lightness = 0.24F),
                            Color(24, 106, 59),
                            Color(27, 79, 114)
                        )
                    )

                    FilledButtonExample {
                        showDialog = true // Afficher la boîte de dialogue
                    }
                    for (message in messages) {
                        Message(message, "Caf", Color.White, 15.sp, FontWeight.W400)
                    }

                    if (showDialog) {
                        alertDialogTest(onDismiss = { showDialog = false }) // Passer une fonction pour masquer la boîte de dialogue
                    }
                }
            }
        }
    }
}



@Composable
fun Message(txt: String, categorie: String, color: Color, size: TextUnit, weight: FontWeight) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(Color(41, 41, 41, 255))
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = "$txt €",
            color = color,
            fontSize = size,
            fontWeight = weight,
            modifier = Modifier.padding(15.dp),
        )

        Text(
            text = categorie,
            color = color,
            fontSize = size,
            fontWeight = weight,
            modifier = Modifier.padding(15.dp),
        )
    }
}

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(
        onClick = {
            onClick() // Appeler la fonction onClick passée en paramètre
        },        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(0.dp, 50.dp),
        colors = ButtonDefaults.buttonColors(Color(41,41,41,255))
    ) {
        Text(
            text = "+",
            modifier = Modifier
                .padding(50.dp, 5.dp)
                .background(Color.Transparent) // Fond transparent pour le texte
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
            val radius = min(centerX, centerY)
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
                    color = Color(31,31,31,255),
                    radius = radius / 1.2f, // Ajustez la taille du trou ici
                    center = Offset(centerX, centerY)
                )
            }
        }

        Text(
            text = money.toString(),
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun alertDialogTest(onDismiss: () -> Unit) {
    val openDialog = remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("0") }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onDismiss() // Appeler la fonction onDismiss passée en paramètre
            },
            title = {
                Text(text = "entre une valeur")
            },
            text = {
                Column() {
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
                        Text("ajouter")
                    }
                }
            }
        )
    }
}
