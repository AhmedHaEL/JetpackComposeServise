package com.learn.activity3bottomnavigationandlazycolumn.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.example.DataServes
import com.example.example.UnComplete
import com.learn.activity3bottomnavigationandlazycolumn.BottomNavigationItem
import com.learn.activity3bottomnavigationandlazycolumn.Navigation
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.NavigationHostBottomScreen
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import kotlinx.coroutines.selects.select


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomScreen(navigation: NavController,serviceList: List<DataServes>,
                 unCompletList: List<UnComplete>,CompletList: List<UnComplete>,PendingList: List<UnComplete>) {


    val navigationController = rememberNavController()
    val item = listOf(
        BottomNavigationItem.Service,
        BottomNavigationItem.Orders,
        BottomNavigationItem.User,
        BottomNavigationItem.More
    )




    Scaffold(
        content = {
            NavigationHostBottomScreen(navigationController,serviceList,unCompletList,CompletList,PendingList)
//            Navigation()
        },

        bottomBar = {


            BottomNavigation(

                backgroundColor = Color(0xff6FC8FB),
                modifier = Modifier
                    .height(80.dp),

            ) {
                val backStack by navigationController.currentBackStackEntryAsState()
                val cuttentRour = backStack?.destination?.route
                item.forEach { select ->
                    BottomNavigationItem(

                        label = {
                            Text(
                                text = select.title,
                                color = Color.White,
                            )
                        },
                        selected = cuttentRour == select.route,
                        icon = {
//                            Icon(imageVector = select.image, contentDescription =null )
                            Image(
                                modifier = Modifier
                                    .align(alignment = Alignment.Top)
                                    .padding(bottom = 9.dp, top = 10.dp),
                                painter = painterResource(id = select.image),
                                contentDescription = null, contentScale = ContentScale.FillBounds
                            )
                        },
                        onClick = { navigationController.navigate(select.route){
                            popUpTo = navigationController.graph.startDestinationId
                            launchSingleTop = true
                        } }
                    )
                }
            }
        }
    )
}

