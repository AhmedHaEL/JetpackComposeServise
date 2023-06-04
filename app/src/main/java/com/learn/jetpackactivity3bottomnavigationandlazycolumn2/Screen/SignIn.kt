package com.learn.activity3bottomnavigationandlazycolumn.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun SignIn(navigation: NavController) {
    var text = mutableStateOf("")
    Column(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    contentColor = Color.White,
                    modifier = Modifier.height(87.dp),
                    backgroundColor = colorResource(id = R.color.colorSccafold),
                    elevation = 10.dp,
                    title = { Text(text = "Sign in") }
                )
            },

            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 26.dp, end = 26.dp, top = 107.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = text.value,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                        ),
                        onValueChange = {
                            text.value = it
                        },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                        ),
                    )
                    TextField(
                        value = text.value,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 128.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                        ),
                        onValueChange = {
                            text.value = it
                        },
                        label = { Text("Password") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                        ),
                    )
                    Button(
                        onClick = { navigation.navigate("Greeting") },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.colorbtnSi)),
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .padding(bottom = 105.dp)
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Login",
                            color = colorResource(id = R.color.white),
                            fontSize = 15.sp
                        )
                    }
                    Text(
                        text = "Forgot Password?",
                        color = colorResource(id = R.color.black),
                        fontSize = 14.sp
                    )
                }
            }
        )
    }
}