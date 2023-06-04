package com.learn.activity3bottomnavigationandlazycolumn.ScreenBottomNav

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.example.example.DataServes
import com.google.accompanist.pager.ExperimentalPagerApi
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.ItemService
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ui.theme.Purple500
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.RatingBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

import com.google.accompanist.pager.*
import com.learn.activity3bottomnavigationandlazycolumn.BottomNavigationItem
import com.learn.activity3bottomnavigationandlazycolumn.BottomNavigationItem.More.image

import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@OptIn(ExperimentalCoroutinesApi::class, ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable

fun ServiceScreen(serviceList: List<DataServes>,navigation: NavController) {
//fun ServiceScreen() {


    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.background),
                contentDescription = null
            )
//            Image(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(280.dp),
//                painter = painterResource(id = R.drawable.layer_2),
//                contentDescription = null
//            )
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 38.dp, start = 19.3.dp, end = 19.3.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shape),
                    contentDescription = null
                )
            }

//            val hasInternetConnection = isNetworkAvailable(context = context)
            Image(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp, bottom = 20.dp),
                painter = painterResource(id = R.drawable.group10533),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .padding(top = 105.dp)
                    .fillMaxSize()
            ) {

                Column() {
                    val images = listOf(
                        "https://media.npr.org/assets/img/2021/08/11/gettyimages-1279899488_wide-f3860ceb0ef19643c335cb34df3fa1de166e2761-s1100-c50.jpg",
                        "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492__480.jpg",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrfPnodZbEjtJgE-67C-0W9pPXK8G9Ai6_Rw&usqp=CAU",
                        "https://i.ytimg.com/vi/E9iP8jdtYZ0/maxresdefault.jpg",
                        "https://cdn.shopify.com/s/files/1/0535/2738/0144/articles/shutterstock_149121098_360x.jpg"
                    )

                    AutoSliding(images)
                }




//                IconButton(modifier = Modifier
//                    .width(242.dp)
//                    .height(107.dp)
//                    .shadow(20.dp, ambientColor = Color(0Xff000000))
//                    .clip(shape = RoundedCornerShape(10))
//                    .align(alignment = Alignment.CenterHorizontally)
//                    .background(Color.White),
//                    onClick = { /*TODO*/ }) {
//
//                }
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 19.dp, end = 19.dp),
            verticalArrangement = Arrangement.Top,
            Alignment.CenterHorizontally
        ) {
            Text(
                text = "Select Service",
                modifier = Modifier.padding(bottom = 16.dp, top = 21.dp),
                fontSize = 20.sp,
                color = Color(0xff0E4DFB),
                fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold
            )

            LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),

                horizontalArrangement = Arrangement.spacedBy(19.dp), content = {
                    itemsIndexed(items = serviceList) { index, item ->
                        ItemService(myDataServes = item,navigation)
                    }
                })


        }
    }

}

val ListOfItem = listOf(
    MyData(service = "Carpenter", image = R.drawable.forma21),
    MyData(service = "Carpenter", image = R.drawable.forma),
    MyData(service = "Carpenter", image = R.drawable.shape21),
    MyData(service = "Carpenter", image = R.drawable.shape1),
    MyData(service = "Carpenter", image = R.drawable.forma21),
    MyData(service = "Carpenter", image = R.drawable.forma),
    MyData(service = "Carpenter", image = R.drawable.shape21),
    MyData(service = "Carpenter", image = R.drawable.shape1),
    MyData(service = "Carpenter", image = R.drawable.forma21),
    MyData(service = "Carpenter", image = R.drawable.forma),
    MyData(service = "Carpenter", image = R.drawable.shape21),
    MyData(service = "Carpenter", image = R.drawable.shape1),
)

@ExperimentalPagerApi
@Composable
fun AutoSliding(images: List<Any>) {
    val pagerState = com.google.accompanist.pager.rememberPagerState(
        pageCount = images.size,
        initialOffscreenLimit = 2
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
        ) { page ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                    .fillMaxSize()
                    .padding(25.dp, 0.dp, 25.dp, 0.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                val natural = images[page]
                Box(
                    modifier = Modifier.fillMaxSize()
                        .align(Alignment.Center)
                ) {
                    LazyRow(
                modifier = Modifier.fillMaxSize(),
            ) {itemsIndexed(images) { index, image ->
                        Image(
                            modifier = Modifier.
                            width(370.dp)
                                .height(137.dp),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = null,
                            painter =rememberImagePainter(
                                data = natural,
                            ),
                        )
                    }}

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(15.dp)
                    ) {
                    }
                }
            }
        }

        //Horizontal dot indicator
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }
}

//@Composable
//fun MyItem(myData: MyData) {
//    Card(
//        modifier = Modifier
//            .width(100.dp)
//            .height(110.dp)
//            .padding(bottom = 16.dp),
//        elevation = 4.dp,
//        shape = RoundedCornerShape(12.dp),
//        border = BorderStroke(0.5.dp, Color(0xffDE1487)),
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize(), verticalArrangement = Arrangement.Center,
//            Alignment.CenterHorizontally
//        ) {
//            Image(
//                modifier = Modifier
//                    .width(40.dp)
//                    .height(40.dp),
//                painter = painterResource(id = myData.image),
//                contentDescription = null
//            )
//            Text(
//                modifier = Modifier.padding(bottom = 5.dp, top = 5.dp),
//                text = myData.service,
//                color = Color(0xff0E4DFB),
//                fontSize = 16.sp
//            )
//        }
//
//
//    }
//}

data class MyData(val service: String, val image: Int)


//val ListOfItem2 = listOf(
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//    MyData2(Order = "Order #52001", Date = "28 Nov 2019", Text = "Service Type : Carpenter"),
//)

//@Composable
//fun MyItem(myData: MyData2) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .width(385.dp)
//            .height(145.dp)
//            .padding(top = 35.dp, start = 21.dp, end = 21.dp),
//        shape = RoundedCornerShape(5.dp), contentColor = colorResource(id = R.color.colorcard),
//        border = BorderStroke(1.dp, Color(0xff707070))
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
////            .fillMaxWidth()
//                .padding(top = 17.dp, start = 21.dp, end = 17.dp)
//        ) {
//            Row(modifier = Modifier
//                .weight(1f)) {
//                Text(modifier = Modifier.weight(3f), text = myData.Order, color = Color.Black)
//                Text(modifier = Modifier.weight(1f), text = myData.Date, color = Color.Black)
//            }
//
//            Column(modifier = Modifier
//                        .weight(1f)
////                .fillMaxWidth()
////                        .padding(top = 30.dp, start = 15.dp, end = 17.dp)
//                ,) {
//
//                Text(
////                    modifier = Modifier.weight(1f),
//                    text = myData.Text,
//                    color = Color.Black
//                )
//            }
//
//        }
//
//
//    }
//}
//
//data class MyData2(val Order: String, val Date: String, val Text: String)
