package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View
import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.example.DataServes
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen.ChoiceCardScreen

object MainViewMode {
    var selectedValue by mutableStateOf("")
}

@SuppressLint("StaticFieldLeak")
//var navigation : NavController = TODO()
@Composable
fun ItemService(myDataServes: DataServes,navigation: NavController) {

    val selectedValue = MainViewMode.selectedValue
    var context =  LocalContext.current
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(110.dp)
            .padding(bottom = 16.dp)
            .clickable(onClick = {
                MainViewMode.selectedValue = "${myDataServes.id}"
                Toast
                    .makeText(context, "${myDataServes.id}", Toast.LENGTH_SHORT)
                    .show()
//                val intent = Intent(context, ChoiceCardScreen::class.java)
//                context.startActivity(intent)
                navigation.navigate("ChoiceCardScreen")
//                navigation.navigate("ChoiceCardScreen/${1}")
            }),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.5.dp, Color(0xffDE1487)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(), verticalArrangement = Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
//                painter = painterResource(id = myData.icon),
                painter = rememberImagePainter(
                    data = myDataServes.icon,

                    builder = {
//                            scale(Scale.FILL)
                        placeholder(coil.compose.base.R.drawable.notification_action_background)
                        transformations(CircleCropTransformation())

                    }
                ),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(bottom = 5.dp, top = 5.dp),
                text = "${myDataServes.name}",
                color = Color(0xff0E4DFB),
                fontSize = 16.sp
            )
        }


    }

}
