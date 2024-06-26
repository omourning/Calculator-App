package com.example.calculator

import android.content.Context
import android.app.Application
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CalculatorApp(){

    var input by remember { mutableStateOf("")}

    fun calculate(input: String): Double {

        var answer = 0.0
        var operator = ""
        var operatorIndex = 0
        for (index in 0..input.length){
            if (input[index] == '+' || input[index] == '-' || input[index] == 'x' || input[index] == '/') {
                operator = input[index].toString()
                operatorIndex = index
                break
            }
        }

        when (operator) {
            "+" -> answer = input.substring(0,operatorIndex).toDouble() + input.substring(operatorIndex+1,input.length).toDouble()
            "-" -> answer = input.substring(0,operatorIndex).toDouble() - input.substring(operatorIndex+1,input.length).toDouble()
            "x" -> answer = input.substring(0,operatorIndex).toDouble() * input.substring(operatorIndex+1,input.length).toDouble()
            "/" -> answer = input.substring(0,operatorIndex).toDouble() / input.substring(operatorIndex+1,input.length).toDouble()
        }

        return answer
    }

    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Calculator", Modifier.padding(80.dp), fontSize = 40.sp)
        Box (modifier = Modifier
            .width(300.dp)
            .height(80.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(10.dp))) {
            Text(text = input, fontSize = 56.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button (onClick = {
                input += "7"}, Modifier.padding(8.dp)) {
                Text(text = "7")
            }
            Button (onClick = {input += "8"}, Modifier.padding(8.dp)) {
                Text(text = "8")
            }
            Button (onClick = {input += "9"}, Modifier.padding(8.dp)) {
                Text(text = "9")
            }
            Button (onClick = {input += "/"}, Modifier.padding(8.dp)) {
                Text(text = "/")
            }
        }
        Row {
            Button (onClick = {input += "4"}, Modifier.padding(8.dp)) {
                Text(text = "4")
            }
            Button (onClick = {input += "5"}, Modifier.padding(8.dp)) {
                Text(text = "5")
            }
            Button (onClick = {input += "6"}, Modifier.padding(8.dp)) {
                Text(text = "6")
            }
            Button (onClick = {input += "x"}, Modifier.padding(8.dp)) {
                Text(text = "x")
            }
        }
        Row {
            Button (onClick = {input += "1"}, Modifier.padding(8.dp)) {
                Text(text = "1")
            }
            Button (onClick = {input += "2"}, Modifier.padding(8.dp)) {
                Text(text = "2")
            }
            Button (onClick = {input += "3"}, Modifier.padding(8.dp)) {
                Text(text = "3")
            }
            Button (onClick = {input += "-"}, Modifier.padding(8.dp)) {
                Text(text = "-")
            }
        }
        Row {
            Button (onClick = {input += "."}, Modifier.padding(8.dp)) {
                Text(text = ".")
            }
            Button (onClick = {input += "0"}, Modifier.padding(8.dp)) {
                Text(text = "0")
            }
            Button (onClick = { input = calculate(input).toString() }, Modifier.padding(8.dp)) {
                Text(text = "=")
            }
            Button (onClick = {input += "+"}, Modifier.padding(8.dp)) {
                Text(text = "+")
            }
        }
    }
}