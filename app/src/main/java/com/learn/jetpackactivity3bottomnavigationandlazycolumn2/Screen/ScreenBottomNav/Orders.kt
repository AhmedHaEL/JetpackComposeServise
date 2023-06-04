package com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.IndicatorHeight
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.example.UnComplete
import com.learn.activity3bottomnavigationandlazycolumn.BottomNavigationItem.More.title
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.OrderTab.CompleteOrder
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.OrderTab.PendingOrder
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.OrderTab.UnCompletedOrder
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewModel

@Composable
fun OrdersScreen(viewModel: MainViewModel,unCompletList: List<UnComplete>,CompletList: List<UnComplete>,PendingList: List<UnComplete>) {
    val color1 = Color(0xFF346EDF)
    val color2 = Color(0xFF6FC8FB)
    val gradientGreenRed = Brush.horizontalGradient(
        0f to color2,
        1000f to color1
    )
    val tabIndex = viewModel.tabIndex.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffEAEFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(98.dp)
                .background(gradientGreenRed)
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Center,
                text = "Item Details",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(selectedTabIndex = tabIndex.value!!,
                indicator = {
                    TabRowDefaults.Indicator(
                        modifier = Modifier
                        .tabIndicatorOffset(it[tabIndex.value!!]).align(Alignment.CenterHorizontally),
                        color = Color(0xFF0E4DFB),
                        height = TabRowDefaults.IndicatorHeight * 1F,

                    )
                },
                ) {
                viewModel.tabs.forEachIndexed { index, title ->
                    Tab(

                        text = {
                            Text(
                                title,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        },
                        selected = tabIndex.value!! == index,
                        onClick = { viewModel.updateTabIndex(index) },
                        modifier = Modifier
                            .height(65.dp)
                            .background(color = Color.White),
//                            .background(Color.White)

                        selectedContentColor = Color(0xff0E4DFB),
                        unselectedContentColor = Color(0xffAFAFAF),
                        interactionSource = MutableInteractionSource(),
                    )
                }
            }

            when (tabIndex.value) {
                0 -> CompleteOrder(viewModel = viewModel, CompletList = CompletList)
                1 -> UnCompletedOrder(viewModel = viewModel, unCompletList = unCompletList)
                2 -> PendingOrder(viewModel = viewModel,PendingList = PendingList)
            }
        }


    }

}

