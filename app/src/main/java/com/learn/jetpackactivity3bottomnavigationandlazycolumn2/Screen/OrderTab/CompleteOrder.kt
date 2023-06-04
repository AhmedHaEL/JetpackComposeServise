package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.OrderTab

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.example.UnComplete
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.ItemOrder
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewModel

@Composable
fun CompleteOrder(viewModel: MainViewModel,CompletList: List<UnComplete>){
//    var isSwipeToTheLeft by remember { mutableStateOf(false) }
//    val dragState = rememberDraggableState(onDelta = { delta ->
//        isSwipeToTheLeft = delta > 0
//    })

    Column(modifier = Modifier
        .fillMaxSize()
        .draggable(
            state = viewModel.dragState.value!!,
            orientation = Orientation.Horizontal,
            onDragStarted = { },
            onDragStopped = {
                viewModel.updateTabIndexBasedOnSwipe()
            }),) {
        Column {
            Spacer(modifier = Modifier.height(3.dp))
            LazyColumn {
                itemsIndexed(items = CompletList){index, item ->
                    ItemOrder(unComplete = item)
                }
            }

            if (CompletList.size == 0){
            Column(modifier = Modifier.fillMaxSize()) {
                Image(alignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(352.dp).padding(top = 80.dp),
                    painter = painterResource(id = R.drawable.card_fild),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
//                Text(text = "كل الطلبات مكتملة", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 30.sp, color = Color(0xffB3BAC5))
                Text(modifier = Modifier.padding(top = 15.dp).align(Alignment.CenterHorizontally),textAlign = TextAlign.Center,
                    text = "كل الطلبات مكتملة", fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xff0E4DFB)
                )
            }


            }

        }
    }
}