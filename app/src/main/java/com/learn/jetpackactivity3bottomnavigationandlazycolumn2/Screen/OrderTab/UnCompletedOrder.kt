package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.OrderTab

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.example.UnComplete
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.ItemOrder
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewModel
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel.ServiceViewModel

@Composable
fun UnCompletedOrder(viewModel: MainViewModel,unCompletList: List<UnComplete>){
//    var isSwipeToTheLeft by remember { mutableStateOf(false) }
//    val dragState = rememberDraggableState(onDelta = { delta ->
//        isSwipeToTheLeft = delta > 0
//    })

    Column(modifier = Modifier
        .fillMaxSize().padding(bottom = 81.dp)
        .draggable(
            state = viewModel.dragState.value!!,
            orientation = Orientation.Horizontal,
            onDragStarted = { },
            onDragStopped = {
                viewModel.updateTabIndexBasedOnSwipe()
            }),
    ) {
        Column() {
            Spacer(modifier = Modifier.height(3.dp))

            LazyColumn {
            itemsIndexed(items = unCompletList){index, item ->
                 ItemOrder(unComplete = item)
            }
        }

//            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}