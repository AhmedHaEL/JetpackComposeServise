package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.example.UnComplete
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun ItemOrder(unComplete: UnComplete) {
//    Spacer(modifier = Modifier.height(90.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.39.dp)
            .padding(bottom = 2.5.dp)
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 17.5.dp, top = 17.dp)
        ) {
            Text(
                text = "Order",
                color = Color(0xff272727),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = " #${unComplete.id}",
                color = Color(0xff272727),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )

//            val sdf = SimpleDateFormat("dd-MM-yyyy")
//
//            val currentDateAndTime = sdf.format(unComplete.createdAt)

            val dateSt = "2017-04-08T18:39:42Z"
            val dateFormatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.000000'Z'")
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            val formattedDate = LocalDateTime.parse(unComplete.createdAt, dateFormatter)
            val res = DateTimeFormatter.ofPattern("dd MMMM yyyy").format(formattedDate)

            Spacer(modifier = Modifier.width(192.dp))
            Text(
                modifier = Modifier.padding(top = 3.dp),
                textAlign = TextAlign.End,
//                text = "${unComplete.createdAt}",
                text = "${res}",
                color = Color(0xff7F8FA6),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }


        Spacer(modifier = Modifier.height(28.dp))

        Row(modifier = Modifier.padding(start = 20.dp, end = 17.5.dp)) {
            Text(
                text = "Service Type : ",
                color = Color(0xff7F8FA6),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                textAlign = TextAlign.End,
                text = "${unComplete.work?.name}",
                color = Color(0xff0E4DFB),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }


    }
}