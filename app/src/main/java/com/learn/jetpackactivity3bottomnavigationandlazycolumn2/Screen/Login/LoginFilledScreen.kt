package com.learn.jetbackcomposescreenproject

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.animation.content.Content
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.LoginViewModel
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.RegisterViewModel
import com.togitech.ccp.component.TogiCountryCodePicker

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginFilledScreen(navigation: NavController) {
    val color1 = Color(0xFF346EDF)
    val color2 = Color(0xFF6FC8FB)
    val gradientGreenRed = Brush.horizontalGradient(
        0f to color2,
        1000f to color1
    )

    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientGreenRed)
    ) {
        Image(
            modifier = Modifier
                .combinedClickable(onClick = {
                    navigation.navigate("ServiceProviderScreen") {
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

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    var text by remember { mutableStateOf(TextFieldValue("")) }


                    OutlinedTextField(
                        value = name.value,
                        modifier = Modifier
                            .padding(start = 25.dp, end = 23.dp, bottom = 15.dp)
                            .width(326.5.dp)
                            .height(50.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                        ),
                        onValueChange = { name.value = it
//                                newText ->
//                            text = newText
                        },
                        placeholder = { Text("Full Name") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                        ),
                    )


//                    var email by remember { mutableStateOf(TextFieldValue("")) }
                    OutlinedTextField(
                        value = email.value,
                        modifier = Modifier
                            .padding(start = 25.dp, end = 23.dp)
                            .width(326.5.dp)
                            .height(50.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                        ),
                        onValueChange = { email.value = it
//                                newText ->
//                            email = newText
                        },
                        placeholder = { Text("Email") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                        ),
                    )


//                    val phoneNumber = rememberSaveable { mutableStateOf("") }

                    TogiCountryCodePicker(
                        text = phoneNumber.value,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 15.dp, bottom = 1.dp)
                            .width(326.5.dp)
                            .height(50.dp),
                        onValueChange = { phoneNumber.value = it },
                        unfocusedBorderColor = MaterialTheme.colors.primary,
                        bottomStyle = false,
                        shape = RoundedCornerShape(5.dp),
                    )
                    //////
//                    val password = remember {mutableStateOf("")}
                    var revealPassword: MutableState<Boolean> = remember {
                        mutableStateOf(false)
                    }
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
                            onValueChange = {password.value = it
//                                    newText ->
//                                password.value = newText
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
                        Spacer(modifier = Modifier.width(10.dp))
                    }


                }

                Spacer(modifier = Modifier.height(37.dp))
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
                    Text(text = "I Read and Accept ", fontSize = 12.sp)
                    Text(
                        text = "Home Service Terms & Conditions",
                        fontSize = 12.sp,
                        color = Color(0xff0E4DFB)
                    )

                }
                Spacer(modifier = Modifier.height(61.5.dp))

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
//                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.combinedClickable(onClick = {
                                navigation.navigate("ServiceProviderScreen")
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
//                            if (name.value != null&& email.value != null&&password.value.length > 8
//                                &&phoneNumber.value != null){
                                RegisterViewModel().performLogin(name = name.value, email = email.value,
                                    password = password.value, phone = phoneNumber.value, navigation = navigation,
                                    context = context)
                                Toast.makeText(context,name.value.toString(),Toast.LENGTH_LONG).show()

//                            }


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
//                            .background(shape = RoundedCornerShape(5.dp) )
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