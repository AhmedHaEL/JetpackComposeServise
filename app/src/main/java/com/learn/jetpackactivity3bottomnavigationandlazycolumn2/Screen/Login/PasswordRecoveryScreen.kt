package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.Login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.togitech.ccp.component.TogiCountryCodePicker

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PasswordRecoveryScreen(navigation: NavController) {
    val color1 = Color(0xFF346EDF)
    val color2 = Color(0xFF6FC8FB)
    val gradientGreenRed = Brush.horizontalGradient(
        0f to color1,
        1000f to color2
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientGreenRed)
    ) {
        Image(
            modifier = Modifier
                .combinedClickable(onClick = {
                    navigation.navigate("LoginScreen") {
                        popUpTo(navigation.graph.id) {
                            inclusive = true
                        }
                    }
                })
                .padding(top = 65.dp, start = 12.dp)
                .width(33.dp)
                .height(33.dp)
                .align(alignment = Alignment.TopStart),
            painter = painterResource(id = R.drawable.back),
            contentDescription = null
        )
        Card(
            modifier = Modifier
                .height(730.dp)
                .fillMaxWidth()
                .background(gradientGreenRed)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(30.dp)
        ) {

            Column {

                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Service provider",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xff0E4DFB)
                            )
                            Spacer(modifier = Modifier.height(7.dp))
                            Image(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(2.dp),
                                painter = painterResource(id = R.drawable.rectangle),
                                contentDescription = null
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier.combinedClickable(onClick = {
                                    navigation.navigate("ServiceProviderScreen")
                                }),
                                text = "Customer",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xff646781)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        var text by remember { mutableStateOf(TextFieldValue("")) }

                        OutlinedTextField(
                            value = text,
                            modifier = Modifier
                                .padding(start = 25.dp, end = 23.dp, bottom = 15.dp)
                                .width(326.5.dp)
                                .height(50.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                            ),
                            onValueChange = { newText ->
                                text = newText
                            },
                            placeholder = { Text("Full Name") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                            ),
                        )


                        var email by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = email,
                            modifier = Modifier
                                .padding(start = 25.dp, end = 23.dp)
                                .width(326.5.dp)
                                .height(50.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                            ),
                            onValueChange = { newText ->
                                email = newText
                            },
                            placeholder = { Text("Email") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                            ),
                        )


                        val phoneNumber = rememberSaveable { mutableStateOf("") }

                        TogiCountryCodePicker(
                            text = phoneNumber.value,
                            modifier = Modifier
                                .padding(start = 20.dp, end = 15.dp, bottom = 1.dp)
                                .width(326.5.dp)
                                .height(50.dp),
                            onValueChange = { phoneNumber.value = it },
                            unfocusedBorderColor = MaterialTheme.colors.primary,
                            bottomStyle = false, //  if true the text-field is below the country code selector at the top.
                            shape = RoundedCornerShape(5.dp),
                        )
                        //////
                        val password = remember {
                            mutableStateOf("")
                        }
                        var revealPassword: MutableState<Boolean> = remember {
                            mutableStateOf(false)
                        } // To reveal the password with toggle
                        Row {
                            Spacer(modifier = Modifier.width(20.dp))
                            OutlinedTextField(
                                textStyle = TextStyle(textAlign = TextAlign.Center),
                                modifier = Modifier
                                    .width(326.5.dp)
                                    .height(60.dp)
                                    .padding(bottom = 11.dp)
                                    .background(Color(0xffF2F6F6)),
                                value = password.value,
                                shape = RoundedCornerShape(5.dp),
                                onValueChange = { newText ->
                                    password.value = newText
                                },
                                visualTransformation = if (revealPassword.value) {
                                    VisualTransformation.None
                                } else {
                                    PasswordVisualTransformation()
                                },
                                trailingIcon = {
                                    if (revealPassword.value) {
                                        IconButton(
                                            onClick = {
                                                revealPassword.value = false
                                            },
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                                                contentDescription = null
                                            )
                                        }
                                    } else {
                                        IconButton(
                                            onClick = {
                                                revealPassword.value = true
                                            },
                                        ) {

                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_visibility_24),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                },
                                singleLine = true,
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                        var service by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = service,
                            modifier = Modifier
                                .padding(start = 30.dp, end = 23.dp)
                                .width(326.5.dp)
                                .height(50.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                            ),
                            onValueChange = { newText ->
                                service = newText
                            },
                            placeholder = { Text("Select service") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                            ),
                        )


                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier.padding(start = 40.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .width(23.dp)
                                .height(23.dp)
                                .padding(end = 10.dp),
                            painter = painterResource(id = R.drawable.check),
                            contentDescription = null
                        )
                        Text(text = "I Read and A ccept ", fontSize = 12.sp)
                        Text(
                            text = "Home Service Terms & Conditions",
                            fontSize = 12.sp,
                            color = Color(0xff0E4DFB)
                        )

                    }
                    Spacer(modifier = Modifier.height(30.5.dp))

                    Row(
                        modifier = Modifier.padding(start = 35.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Have Account?",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                modifier = Modifier.combinedClickable(onClick = {
                                    navigation.navigate("LoginScreen")
                                }),
                                text = "SIGN IN",
                                textDecoration = TextDecoration.Underline,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xff0E4DFB)
                            )
                        }

                        Spacer(modifier = Modifier.width(56.5.dp))

                        Button(
                            onClick = {
                                navigation.navigate("BottomScreen") {
                                    popUpTo(navigation.graph.id) {
                                        inclusive = true
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            modifier = Modifier
                                .height(55.dp)
                                .width(164.dp),
                            shape = RoundedCornerShape(5.dp), contentPadding = PaddingValues(),
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(gradientGreenRed)
                                    .height(55.dp)
                                    .width(164.dp),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = "SIGN UP",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}