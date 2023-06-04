package com.learn.jetpackactivity3bottomnavigationandlazycolumn2

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.example.DataServes
import com.example.example.UnComplete
import com.learn.activity3bottomnavigationandlazycolumn.BottomNavigationItem
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.MoreScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.OrdersScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.ServiceScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.UserScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.AddOrderScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.ChoiceCardScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewModel

@Composable
fun NavigationHostBottomScreen(
    na: NavHostController,
    serviceList: List<DataServes>,
    unCompletList: List<UnComplete>,
    CompletList: List<UnComplete>,
    PendingList: List<UnComplete>,
) {
    val Navgation = rememberNavController()

    NavHost(navController = na, startDestination = BottomNavigationItem.Service.route) {
        NavBottomScreenGraph()
        composable(route = BottomNavigationItem.Service.route) {
            ServiceScreen(serviceList = serviceList,na)
//            ServiceScreen(emptyList())
        }
        composable(route = BottomNavigationItem.Orders.route) {
            OrdersScreen(
                viewModel = MainViewModel(Application()),
                unCompletList = unCompletList,
                CompletList = CompletList,
                PendingList = PendingList
            )
        }
        composable(route = BottomNavigationItem.User.route) {
            UserScreen()
        }
        composable(route = BottomNavigationItem.More.route) {
            MoreScreen()
        }

        composable(route = "ChoiceCardScreen") {
            ChoiceCardScreen(navigation = na)
        }

        composable(route = "AddOrderScreen"){
            AddOrderScreen(navigation = na)
        }
    }
}