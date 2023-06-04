package com.learn.jetpackactivity3bottomnavigationandlazycolumn2

sealed class ScreenNavigation(val rout : String){
//    object all : ScreenNavigation(rout = "all")
    object ServiceScreen : ScreenNavigation(rout = "ServiceScreen")
    object OrdersScreen : ScreenNavigation(rout = "OrdersScreen")
    object UserScreen : ScreenNavigation(rout = "UserScreen")
    object MoreScreen : ScreenNavigation(rout = "MoreScreen")
}
