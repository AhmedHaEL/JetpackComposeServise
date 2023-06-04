package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.learn.jetbackcomposescreenproject.OnBoarding1
import com.learn.jetbackcomposescreenproject.OnBoarding2
import com.learn.jetbackcomposescreenproject.OnBoarding3
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.LoginViewModel
import kotlinx.coroutines.delay


@Composable
fun SplachScreen(navigation: NavController) {

//    if (LoginViewModel().go == true){
//        navigation.navigate("OnBoarding1") {
//            popUpTo(navigation.graph.id) {
//                inclusive = true
//            }
//        }
//    }


    LaunchedEffect(key1 = null) {
        delay(3000)
        navigation.navigate("OnBoarding1") {
            popUpTo(navigation.graph.id) {
                inclusive = true
            }
        }

    }

    val color1 = Color(0xFF346EDF)
    val color2 = Color(0xFF6FC8FB)
    val gradientGreenRed = Brush.verticalGradient(
        0f to color1,
        1000f to color2
    )

    Box(
        modifier = Modifier
            .background(gradientGreenRed)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .width(240.09.dp)
                .height(341.8.dp)
                .align(alignment = Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.layer3),
            contentDescription = null
        )
    }
}