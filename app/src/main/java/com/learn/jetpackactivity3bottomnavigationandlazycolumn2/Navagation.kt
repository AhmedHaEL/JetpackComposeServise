package com.learn.activity3bottomnavigationandlazycolumn

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.example.DataServes
import com.example.example.UnComplete
import com.learn.activity3bottomnavigationandlazycolumn.Screen.*
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.MoreScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.OrdersScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.ServiceScreen
import com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav.UserScreen
import com.learn.jetbackcomposescreenproject.*
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.NavBottomScreenGraph
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.AddOrderScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.CardInfoFilledScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.ChoiceCardScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.Login.PasswordRecoveryScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.Login.ServiceProviderScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.SplachScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewModel

@Composable
fun Navigation(serviceList: List<DataServes>,unCompletList: List<UnComplete>,
               CompletList: List<UnComplete>,PendingtList: List<UnComplete>){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplachScreen"){

        NavBottomScreenGraph()

        composable(route = "WelcomeScreen"){
            WelcomeScreen(navigation = navController)
        }
        composable(route = "SignIn"){
            SignIn(navigation = navController)
        }
//        composable(route = "Service"){
//            Service(navigation = navController)
//        }
        composable(route = "BottomScreen"){
            BottomScreen(navigation = navController,serviceList,unCompletList,CompletList,PendingtList)
        }
        composable(route = "LoginFilledScreen"){
            LoginFilledScreen(navigation = navController)
        }
        composable(route = "LoginScreen"){
            LoginScreen(navigation = navController)
        }
        composable(route = "PasswordRecoveryScreen"){
            PasswordRecoveryScreen(navigation = navController)
        }
        composable(route = "ServiceProviderScreen"){
            ServiceProviderScreen(navigation = navController,)
        }
        composable(route = "OnBoarding1"){
            OnBoarding1(navigation = navController)
        }
        composable(route = "OnBoarding2"){
            OnBoarding2(navigation = navController)
        }
        composable(route = "OnBoarding3"){
            OnBoarding3(navigation = navController)
        }
        composable(route = "SplachScreen"){

            SplachScreen(navigation = navController)
        }
        composable(route = "CardInfoFilledScreen"){
            CardInfoFilledScreen(navigation = navController)
        }

        composable(route = "ChoiceCardScreen"){
            ChoiceCardScreen(navigation = navController)
        }
        composable(route = "AddOrderScreen"){
            AddOrderScreen(navigation = navController)
        }
//        composable(route = BottomNavigationItem.Service.route){
////            ServiceScreen(emptyList())
//        }
//        composable(route = BottomNavigationItem.Orders.route){
//            OrdersScreen(viewModel = MainViewModel(Application()),unCompletList)
//        }
//        composable(route = BottomNavigationItem.User.route){
//            UserScreen()
//        }
//        composable(route = BottomNavigationItem.More.route){
//            MoreScreen()
//        }
    }
}