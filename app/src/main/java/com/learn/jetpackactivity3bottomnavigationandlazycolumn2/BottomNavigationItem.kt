package com.learn.activity3bottomnavigationandlazycolumn

import androidx.compose.ui.graphics.vector.ImageVector
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R

sealed class BottomNavigationItem(val title:String,val route:String,val image:Int) {


object Service:BottomNavigationItem(
    route = "Service",
    title = "Service",
    image = R.drawable.layer_2
)

object Orders:BottomNavigationItem(
    route = "Orders",
    title = "Orders",
    image = R.drawable.receipt
)

object User:BottomNavigationItem(
    route = "User",
    title = "User",
    image = R.drawable.icons5
)

object More:BottomNavigationItem(
    route = "More",
    title = "More",
    image = R.drawable.ic_more_horiz_24px
)
}