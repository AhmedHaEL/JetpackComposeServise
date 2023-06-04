package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen

import android.graphics.Insets.add
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import java.io.File

@Composable
fun CardInfoFilledScreen(navigation: NavController) {
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
        ) {
            Spacer(modifier = Modifier.width(35.dp))
            Image(
                modifier = Modifier
                    .width(12.01.dp)
                    .height(12.01.dp),
                painter = painterResource(id = R.drawable.times),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(18.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(272.dp),
            painter = painterResource(id = R.drawable.card_fild),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(73.dp))
        Row {
            Text(
                text = "ORDER ", fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xff272727)
            )
            Text(
                text = "Done ", fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xff0E4DFB)
            )
            Text(
                text = "!", fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xffAF8344)
            )
        }

        Spacer(modifier = Modifier.height(13.dp))
        Text(
            text = "The ORDER has been sent. A technician will\n contact you", fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xff272727), textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
            },

            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .width(255.dp)
                .height(55.dp),
            contentPadding = PaddingValues(),
        ) {
            Box(
                modifier = Modifier
                    .background(gradientGreenRed)
                    .width(255.dp)
                    .height(55.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Go to Home",
                    color = colorResource(id = R.color.white),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}