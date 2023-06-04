package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.Screen

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.DataStore.StoreUserEmail
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.R
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.View.MainViewMode
import kotlinx.coroutines.launch


const val PREFERENCE_NAME = "MyDataStore"

//Instance of DataStore
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

@Composable
fun ChoiceCardScreen(navigation: NavController) {
//fun ChoiceCardScreen(navigation: NavController? = null) {
    val selectedValue = MainViewMode.selectedValue
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.shape_profile),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 40.dp, start = 10.dp)
                        .width(33.dp)
                        .height(33.dp),
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 40.dp),
                    text = "Smith ", fontSize = 20.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(31.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            var photoUri : Uri? remember { mutableStateListOf<Uri>(null) }
//            var photoUri: Uri? by remember { mutableStateOf(null) }
//            var photoUri by remember { mutableStateOf<Uri?>(null) }
            var selectedImageUris by remember {
                // It won't work with mutableStateListOf
                mutableStateOf<List<Uri?>>(emptyList())
            }
//            val launcher = rememberLauncherForActivityResult(
//                ActivityResultContracts.PickVisualMedia()) { uri ->
//                //When the user has selected a photo, its URI is returned here
//                photoUri = uri
//            }

            val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.PickMultipleVisualMedia(),
                onResult = { uris -> selectedImageUris = uris }
            )

            Column {
                LazyColumn(userScrollEnabled = true) {
                    item {
                        Button(
                            onClick = {

//                        launcher.launch(
//                            PickVisualMediaRequest(
//                            //Here we request only photos. Change this to .ImageAndVideo if
//                            //you want videos too.
//                            //Or use .VideoOnly if you only want videos.
//                            mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
//                        )
//                        )

                                multiplePhotoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )


                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            shape = RoundedCornerShape(5.dp),

                            border = BorderStroke(1.dp, Color(0xff0E4DFB)),
                            modifier = Modifier
                                .height(50.dp)
                                .width(335.89.dp),

                            contentPadding = PaddingValues(),

                            ) {
                            Row(
                                modifier = Modifier
                                    .background(Color.White)
                                    .height(50.dp)
                                    .width(335.89.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

//                        if (photoUri != null) {
//                            //Use Coil to display the selected image
//                            val painter = rememberAsyncImagePainter(
//                                ImageRequest
//                                    .Builder(LocalContext.current)
//                                    .data(data = photoUri)
//                                    .build()
//                            )
//
//                            Image(
//                                painter = painter,
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .padding(5.dp)
//                                    .fillMaxWidth()
//                                    .border(6.0.dp, Color.Gray),
//                                contentScale = ContentScale.Crop
//                            )
//
//
//                        }

//                        items(selectedImageUris) { uri ->
//                            AsyncImage(
//                                model = uri,
//                                contentDescription = null,
//                                modifier = Modifier.fillMaxWidth(),
//                                contentScale = ContentScale.Crop
//                            )
//                        }


                                Spacer(modifier = Modifier.width(23.dp))

                                Image(
                                    modifier = Modifier
                                        .width(27.19.dp)
                                        .height(27.19.dp),
                                    painter = painterResource(id = R.drawable.uplod_image),
                                    contentDescription = null
                                )

                                Spacer(modifier = Modifier.width(75.dp))

                                Text(
                                    textAlign = TextAlign.Center,
                                    text = "Image Problem",
                                    color = Color(0xff272727),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                    items(selectedImageUris) { uri ->
                    Row(modifier = Modifier.background(Color.Magenta).fillMaxSize()) {



                            AsyncImage(
                                model = uri,
                                contentDescription = null,
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(25.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    textAlign = TextAlign.Start,
                    text = "image must be no more than 2 MB Max 5 Image",
                    color = Color(0xff7F8FA6),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(43.dp))
            }
            // context
            val context2 = LocalContext.current
            // scope
            val scope = rememberCoroutineScope()
            // datastore Email
            val dataStore = StoreUserEmail(context)
            // get saved email
            val savedDetails = dataStore.getDetails.collectAsState(initial = "")
            val savedImages = dataStore.getImages.collectAsState(initial = "")

            var text2 by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(

//                text = Text(text = savedDetails.value!!),
                value = text2,
                modifier = Modifier
                    .padding(start = 25.dp, end = 23.dp, bottom = 15.dp)
                    .width(335.89.dp)
                    .height(120.64.dp)
                    .background(Color.White),
                shape = RoundedCornerShape(5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color(0xff0E4DFB)
                ),

                onValueChange = { newText ->
                    text2 = newText
//                    text =

                },
                placeholder = {
                    Text(
                        "More Details About Problem …...",
                        color = Color(0xffC2CECE),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
            )

            Spacer(modifier = Modifier.height(335.dp))
            Button(
                onClick = {
                    if (text2.text != null && selectedImageUris.isNotEmpty() ){
                        scope.launch {
                            dataStore.saveDetails(text2.text)
                            dataStore.saveImages(selectedImageUris)
//                            if (navigation != null) {
                            navigation.navigate("AddOrderScreen")
                            Toast.makeText(context,text2.text,Toast.LENGTH_SHORT).show()
//                    Toast.makeText(context,savedDetails.value!!,Toast.LENGTH_SHORT).show()
                            Toast.makeText(context,savedImages.value.toString(),Toast.LENGTH_SHORT).show()
//                            }
                        }
                    }



//                    writeString()
                },

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .height(55.dp)
                    .width(305.dp),
                contentPadding = PaddingValues(),
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xff222328))
                        .height(55.dp)
                        .width(305.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "Next",
                        color = colorResource(id = R.color.white),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
//fun Context.readString(key: String): Flow<String> {
//    return dataStore.data.map{ pref ->
//        pref[stringPreferencesKey(key)] ?: ""
//    }
//}
//
//suspend fun Context.writeString(key: String, value: String) {
//    dataStore.edit { pref -> pref[stringPreferencesKey(key)] = value }
//}

