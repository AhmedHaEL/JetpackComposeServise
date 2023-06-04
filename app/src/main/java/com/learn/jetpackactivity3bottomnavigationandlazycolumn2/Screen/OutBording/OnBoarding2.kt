package com.learn.jetbackcomposescreenproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R

@Composable
fun OnBoarding2(navigation: NavController) {
    val color1 = Color(0xFF346EDF)
    val color2 = Color(0xFF6FC8FB)
    val gradientGreenRed = Brush.horizontalGradient(
        0f to color1,
        1000f to color2
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.onbording2), contentDescription = null,
            modifier = Modifier.padding(top = 135.3.dp, bottom = 21.3.dp),
        )

        Text(
            text = "Fast reservation with technicians \n" +
                    "and craftsmen",
            color = colorResource(id = R.color.colorText),
            modifier = Modifier.padding(bottom = 150.dp),
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = {
                navigation.navigate("OnBoarding3") {
                    popUpTo(navigation.graph.id) {
                        inclusive = true
                    }
                }
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
                    .background(gradientGreenRed)
                    .height(55.dp)
                    .width(305.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Next",
                    color = colorResource(id = R.color.white),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}