package com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.ItemMore

@Composable
fun MoreScreen() {
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
                    text = "More ", fontSize = 20.sp,
                    color = Color.White
                )

            }
        }

        ItemMore(text = "Change Password", width = 220.dp)
        ItemMore(text = "FAQ's", width = 305.dp)
        ItemMore(text = "About App", width = 270.dp)
        ItemMore(text = "Terms & Conditions", width = 210.dp)
        ItemMore(text = "Privacy Policy", width = 250.dp)
        ItemMore(text = "Rate App", width = 280.dp)
        ItemMore(text = "Delete Account", width = 240.dp)

    }


}