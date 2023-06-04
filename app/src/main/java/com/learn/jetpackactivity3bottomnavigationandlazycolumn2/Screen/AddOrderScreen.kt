@file:Suppress("UNCHECKED_CAST")

package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.DataStore.StoreUserEmail
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewMode
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.CreateOrderViewModel
import com.togitech.ccp.component.TogiCountryCodePicker

@Composable
fun AddOrderScreen(navigation: NavController) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.shape_profile),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 40.dp, start = 10.dp)
                        .width(33.dp)
                        .height(33.dp),
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 40.dp),
                    text = "Location ", fontSize = 20.sp,
                    color = Color.White
                )

            }

        }

        Spacer(modifier = Modifier.height(31.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            var text by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                value = text,
                modifier = Modifier
                    .padding(start = 25.dp, end = 23.dp, bottom = 15.dp)
                    .width(335.89.dp)
                    .height(120.64.dp)
                    .background(Color.White),
                shape = RoundedCornerShape(5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color(0xff0E4DFB)
                ),
                onValueChange = { newText ->
                    text = newText
                },
                placeholder = {
                    Text(
                        "More Details About Problem …...",
                        color = Color(0xffC2CECE),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
            )

            val phoneNumber = rememberSaveable { mutableStateOf("") }

            TogiCountryCodePicker(
                text = phoneNumber.value,
                modifier = Modifier
                    .width(340.5.dp)
                    .height(50.dp),
                onValueChange = { phoneNumber.value = it },
                unfocusedBorderColor = MaterialTheme.colors.primary,
                bottomStyle = false,
                shape = RoundedCornerShape(5.dp),
            )

            Spacer(modifier = Modifier.height(335.dp))
            // context
            val context2 = LocalContext.current
            // scope
            val scope = rememberCoroutineScope()
            // datastore Email
            val dataStore = StoreUserEmail(context)
            val savedDetails = dataStore.getDetails.collectAsState(initial = "")
            val savedImages = dataStore.getImages.collectAsState(initial = "")
            Button(
                onClick = {

//                    Toast.makeText(context,MainViewMode.selectedValue, Toast.LENGTH_SHORT).show()

                    CreateOrderViewModel().performCreateOrder("${MainViewMode.selectedValue}",
                    savedDetails.value.toString(),text.text, listOf(savedImages),
                    phoneNumber.value,"234.1","23423.2",navigation,context)
//                    Toast.makeText(context,savedDetails.value.toString(), Toast.LENGTH_SHORT).show()
//                    Toast.makeText(context,text.text, Toast.LENGTH_SHORT).show()
//                    Toast.makeText(context,savedImages.value.toString(), Toast.LENGTH_SHORT).show()
                    Toast.makeText(context,phoneNumber.value, Toast.LENGTH_SHORT).show()
                },

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .height(55.dp)
                    .width(305.dp),
                contentPadding = PaddingValues(),
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xff222328))
                        .height(55.dp)
                        .width(305.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "Add Order",
                        color = colorResource(id = R.color.white),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

