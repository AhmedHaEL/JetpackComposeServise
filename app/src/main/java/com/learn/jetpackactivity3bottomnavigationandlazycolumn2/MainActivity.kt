package com.learn.jetpackactivity3bottomnavigationandlazycolumn2

import android.os.Bundle
import android.telecom.Call
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.example.DataServes
import com.example.example.UnComplete
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.learn.activity3bottomnavigationandlazycolumn.Navigation
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.ServiceScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Map.MapActivity
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Map.MapApplication
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.ItemOrder
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.OrderCompleteViewModel
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.OrderPendingViewModel
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.OrderUnCompleteViewModel
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.ServiceViewModel
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ui.theme.JetpackActivity3bottomnavigationandlazycolumn2Theme

class MainActivity : ComponentActivity() {

    val serviceViewModel by viewModels<ServiceViewModel>()
    val orderUnCompleteViewModel by viewModels<OrderUnCompleteViewModel>()
    val orderCompleteViewModel by viewModels<OrderCompleteViewModel>()
    val orderPendingViewModel by viewModels<OrderPendingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WindowCompat.setDecorFitsSystemWindows(window, false)

            val systemUiController = rememberSystemUiController()
            val useDarkIcons = !isSystemInDarkTheme()

            systemUiController.isStatusBarVisible = true // Status bar
            systemUiController.isNavigationBarVisible = false // Navigation bar
//            systemUiController.isSystemBarsVisible = false // Status & Navigation bars

            DisposableEffect(systemUiController, useDarkIcons) {
                // Update all of the system bar colors to be transparent, and use
                // dark icons if we're in light theme
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = useDarkIcons
                )

                onDispose {}
            }
            val color1 = Color(0xFF6FC8FB)
            val color2 = Color(0xFF0E4DFB)
            val gradientGreenRed = Brush.horizontalGradient(
                0f to color1,
                1000f to color2
            )
            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = true
            )

//            ServiceScreen(serviceList =serviceViewModel.serviceListResponse )
            Navigation(serviceList = serviceViewModel.serviceListResponse,
                unCompletList = orderUnCompleteViewModel.orderUnCompleteListResponse,
                CompletList = orderCompleteViewModel.orderCompleteListResponse,
                PendingtList = orderPendingViewModel.orderPendingListResponse)
            serviceViewModel.getService()
            orderUnCompleteViewModel.getOrderUnComplete()
            orderCompleteViewModel.getOrderComplete()
            orderPendingViewModel.getOrderPending()
//            funListOrderUnComplete(listOrderUnComplete = orderUnCompleteViewModel.orderUnCompleteListResponse)


//            Navigation()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Composable
//fun funListOrderUnComplete(listOrderUnComplete: List<UnComplete?>) {
//    Column {
//        LazyColumn {
//            itemsIndexed(items = listOrderUnComplete){index, item ->
//                item?.let { ItemOrder(unComplete = it) }
//            }
//        }
//    }
//
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackActivity3bottomnavigationandlazycolumn2Theme {
        Greeting("Android")
    }
}