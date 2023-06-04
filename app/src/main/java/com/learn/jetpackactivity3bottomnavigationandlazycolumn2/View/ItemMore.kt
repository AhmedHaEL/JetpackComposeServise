package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R

@Composable
fun ItemMore(text : String,width:Dp) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 14.dp, bottom = 19.dp)
    ) {

        Text(textAlign = TextAlign.Start,
            text = text, fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
            color = Color(0xff272727)
        )
        Spacer(modifier = Modifier.width(width))
        Image(
            modifier = Modifier
                .width(13.dp)
                .height(26.dp),
            painter = painterResource(id = R.drawable.arrow_profile),
            contentDescription = null
        )
    }
}