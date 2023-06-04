package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.Login

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
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
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.LoginViewModel
import com.togitech.ccp.component.TogiCountryCodePicker

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ServiceProviderScreen(navigation: NavController) {

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
                .padding(top = 65.dp)
                .width(143.91.dp)
                .height(100.03.dp)
                .align(alignment = Alignment.TopCenter),
            painter = painterResource(id = R.drawable.ima_login),
            contentDescription = null
        )
        Card(
            modifier = Modifier
                .height(680.dp)
                .fillMaxWidth()
                .background(gradientGreenRed)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(30.dp)
        ) {

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
                            modifier = Modifier.combinedClickable(onClick = {
                                navigation.navigate("LoginScreen")
                            }),
                            text = "Service provider",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xff646781)
                        )

                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Customer",
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
                }


                var email by remember { mutableStateOf(TextFieldValue("")) }
                val usernameState = remember { mutableStateOf("") }
                val passwordState = remember { mutableStateOf("") }
                OutlinedTextField(
                    value = usernameState.value,
//                    value = email,
                    modifier = Modifier
                        .padding(top = 47.dp, start = 40.dp, end = 37.dp, bottom = 32.dp)
                        .width(326.5.dp)
                        .height(50.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                    ),
                    onValueChange = { usernameState.value = it
//                            newText ->
//                        email = newText
                    },
                    placeholder = { Text("Email") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                    ),
                )

                val password = remember {
                    mutableStateOf("")
                }
                var revealPassword: MutableState<Boolean> = remember {
                    mutableStateOf(false)
                } // To reveal the password with toggle
                Row {
                    Spacer(modifier = Modifier.width(40.dp))
                    OutlinedTextField(
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        modifier = Modifier
                            .width(314.5.dp)
                            .height(50.dp)
                            .background(Color(0xffF2F6F6)),
                        value = passwordState.value,
//                        value = password.value,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { passwordState.value = it
//                                newText ->
//                            password.value = newText
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
                    Spacer(modifier = Modifier.width(40.dp))
                }
                Spacer(modifier = Modifier.height(41.5.dp))
                Row(
                    modifier = Modifier.padding(start = 35.dp),
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
                    Text(text = "Remember me", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(93.dp))
                    Text(text = "Forgot Password?", fontSize = 15.sp)
                }
                Spacer(modifier = Modifier.height(41.5.dp))
                Row(
                    modifier = Modifier.padding(start = 35.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "New Member?",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            modifier = Modifier.combinedClickable(onClick = {
                                navigation.navigate("LoginFilledScreen")
                            }),
                            text = "SIGN UP",
                            textDecoration = TextDecoration.Underline,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xff0E4DFB)
                        )
                    }

                    Spacer(modifier = Modifier.width(56.5.dp))
                    val context = LocalContext.current
                    Button(
                        onClick = {
//                            LoginViewModel().performLogin(usernameState.value, passwordState.value)
                            LoginViewModel().performLogin(usernameState.value, passwordState.value,
                                navigation = navigation, context = context)
//                            navigation.navigate("BottomScreen") {
//                                popUpTo(navigation.graph.id) {
//                                    inclusive = true
//                                }
//                            }
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
                                text = "LOGIN",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(200.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .align(
                            Alignment.CenterHorizontally
                        )
                        .combinedClickable(onClick = {
                            navigation.navigate("BottomScreen")
                        })
                ) {
                    Text(
                        text = "Get Start Now",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xff272727)
                    )
                    Spacer(modifier = Modifier.width(7.3.dp))
                    Image(
                        modifier = Modifier
                            .width(11.69.dp)
                            .height(9.55.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = null
                    )
                }
            }
        }
    }
}