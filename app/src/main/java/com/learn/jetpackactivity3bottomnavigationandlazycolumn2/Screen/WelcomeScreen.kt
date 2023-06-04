package com.learn.activity3bottomnavigationandlazycolumn.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R


@Composable
fun WelcomeScreen(navigation: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bacgroung), contentDescription = null,
            modifier = Modifier.padding(top = 103.3.dp, bottom = 71.3.dp),
        )

        Text(
            text = "استمتع بخدمة حجز غرفة في فندق \n" +
                    "مع تطبيق ترحال",
            color = colorResource(id = R.color.colorText),
            modifier = Modifier.padding(bottom = 131.dp),
            textAlign = TextAlign.Center,
            fontSize = 21.sp
        )

        Button(
            onClick = {
                navigation.navigate("SignIn")
            },
            colors = ButtonDefaults.buttonColors(Color.White),
            border = BorderStroke(1.dp, color = colorResource(id = R.color.colorBorder)),
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .height(46.dp)
                .width(169.dp)
        ) {
            Text(text = "التالي", color = colorResource(id = R.color.colorbtt), fontSize = 15.sp)
        }
    }
}
