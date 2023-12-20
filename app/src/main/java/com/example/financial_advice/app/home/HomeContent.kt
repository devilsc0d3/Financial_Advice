package com.example.financial_advice.app.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.financial_advice.R
import com.example.financial_advice.app.core.model.ModelData
import com.example.financial_advice.app.mainData2
import com.example.financial_advice.app.money
import com.example.financial_advice.app.suggestions

@Composable
fun Message(txt: String, category: String, color: Color, size: TextUnit, weight: FontWeight, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(Color(76, 158, 170, 255))
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
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = "+",
            modifier = Modifier
                .padding(50.dp, 5.dp)
                .background(Color.Transparent)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogTest(onDismiss: () -> Unit) {
    val openDialog = remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("0") }
    var selectedCategory by remember { mutableStateOf("") }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onDismiss()
            },
            title = {
                Text(text = stringResource(R.string.enter_value))
            },
            text = {
                Column {
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    DropDownMenu2 { selectedValue ->
                        selectedCategory = selectedValue
                    }
                }
            },

            confirmButton = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color(24, 91, 100, 255)),
                        onClick = {
                            openDialog.value = false

                            if (text.toFloat() != 0f) {
                                money -= text.toFloat()
                                if (selectedCategory == "") {
                                    selectedCategory = "Other"
                                }
                                val dat = ModelData(money = text.toFloat(), description = null, category = selectedCategory)
                                mainData2.add(dat)
                            }
                            onDismiss()
                        }
                    ) {
                        Text(stringResource(R.string.add))
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu2(onItemSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = { Text(stringResource(R.string.enter_category)) },
            readOnly = true,
            trailingIcon = {
                Icon(
                    icon,
                    "contentDescription",
                    Modifier.clickable { expanded = !expanded }
                )
            },
            enabled = true
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        selectedText = label
                        expanded = false
                        onItemSelected(label)
                    },
                    text = {
                        Text(text = label)
                    },
                )
            }
        }
    }
}


@Composable
fun Diagram(finalValue: Float, variableValue: Float) {
    val percentage = variableValue / finalValue
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.diagram), color = Color.Gray, fontSize = 20.sp, fontWeight = FontWeight(800))
            Text(
                text = money.toString(),
                color = Color.Gray,
                fontSize = 40.sp,
                fontWeight = FontWeight(800),
            )
            Spacer(modifier = Modifier.height(25.dp))
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                progress = percentage,
                color = Color(24, 91, 100, 255),
            )
        }
    }
}