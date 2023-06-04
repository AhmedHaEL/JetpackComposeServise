package com.learn.jetpackactivity3bottomnavigationandlazycolumn2

import android.app.Application
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.learn.activity3bottomnavigationandlazycolumn.BottomNavigationItem
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.MoreScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.OrdersScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.ServiceScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.UserScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewModel
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.ServiceViewModel

fun NavGraphBuilder.NavBottomScreenGraph() {

    navigation(startDestination = ScreenNavigation.ServiceScreen.rout, route = "AllScreen"){
        composable(route = ScreenNavigation.ServiceScreen.rout){
//            ServiceScreen(serviceList = serviceList)
//            ServiceScreen()
        }
        composable(route = ScreenNavigation.OrdersScreen.rout){
//            OrdersScreen(viewModel = MainViewModel(Application()))
        }
        composable(route = ScreenNavigation.UserScreen.rout){
            UserScreen()
        }
        composable(route = ScreenNavigation.MoreScreen.rout){
            MoreScreen()
        }
    }

}