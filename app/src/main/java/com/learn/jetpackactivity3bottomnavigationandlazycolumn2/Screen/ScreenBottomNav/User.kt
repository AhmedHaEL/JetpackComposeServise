package com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.ItemMore

@Composable
fun UserScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffF6F7FB))
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(158.dp),
            painter = painterResource(id = R.drawable.bg_profile),
            contentDescription = null, contentScale = ContentScale.FillBounds
        )

        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .width(70.dp)
                .height(70.dp)
                .padding(end = 0.dp, top = 40.dp),
            painter = painterResource(id = R.drawable.ic_setting),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .padding(top = 150.dp),
        ) {
            Card(

                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .height(159.dp)
                        .padding(top = 15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(19.dp))
                    Row() {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Seraj Al Mutawa ", fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xff293340)
                        )
                        Image(
                            modifier = Modifier
                                .align(Alignment.Top)
                                .width(16.dp)
                                .height(16.dp),
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = null
                        )
                    }
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Riyadh, Saudi Arabia", fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff272727)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(309.dp)
                    .background(Color.White)
            ) {
                Spacer(modifier = Modifier.height(65.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 14.dp, bottom = 19.dp)
                ) {

                    Text(
                        textAlign = TextAlign.Start,
                        text = "Language", fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
                        color = Color(0xff272727)
                    )

                    Spacer(modifier = Modifier.width(205.dp))

                    Text(
                        textAlign = TextAlign.Start,
                        text = "English", fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
                        color = Color(0xffC2CECE)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Image(
                        modifier = Modifier
                            .width(13.dp)
                            .height(26.dp),
                        painter = painterResource(id = R.drawable.arrow_profile),
                        contentDescription = null
                    )
                }

                ItemMore(text = "My Rates", width = 270.dp)
                ItemMore(text = "Contact us", width = 260.dp)
                ItemMore(text = "Share App", width = 260.dp)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    painter = painterResource(id = R.drawable.ic_join),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    textAlign = TextAlign.Start,
                    text = "SIGN OUT", fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
                    color = Color(0xff0E4DFB)
                )

            }

        }

        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(214.dp)
                .height(214.dp)
                .padding(top = 95.dp),
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = null
        )
    }
}