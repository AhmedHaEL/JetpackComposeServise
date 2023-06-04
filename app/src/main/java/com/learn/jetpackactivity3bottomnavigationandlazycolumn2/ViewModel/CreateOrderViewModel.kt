package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.NetWork.*
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreateOrderViewModel() : ViewModel() {

    fun performCreateOrder(
        work_id: String, details: String
        , details_address: String, photos: List<State<Any>>
        , phone: String, lat: String, long: String
                           , navigation: NavController
        ,
        context: Context) {

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://studentucas.awamr.com/api/") // استبدل هذا بعنوان URL الخاص بالخادم الخاص بك
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(OkHttpClient.Builder().addInterceptor(JsonHeaderInterceptor2()).build())
//            .build()
//
//        val apiCreateOrder = retrofit.create(ApiCreateOrder::class.java)


        val apiCreateOrder = ApiService.getInstance()

        viewModelScope.launch {
            try {
                val response = apiCreateOrder.createOrder("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiJlZTgzOGNhMTFmMDYxYWI3NzE1NTMwZDAzZDhjMzQyMjhjMTUyODRhYjUzOTAzYzAxZmRiYmEyOGI0ODlhOWRjYmI1N2E2NTkwN2U5NjhkZCIsImlhdCI6MTY4NTQzMDQyNSwibmJmIjoxNjg1NDMwNDI1LCJleHAiOjE3MTcwNTI4MjUsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.HGDlVnA0yAGPODSOtrLSMeNyY27X0O4O0T3CxVqpNQLpUe_mBSGKltnIg8_uCMGEJ16Qa7P8OZI23b3lnWyv0F3U7IG64Mwe23a2sjlMfiSNU0KgH1q2fMsqN9mgUy6YT57wC5qsnX0kf4A45WUEavbEVKcIa53EXTohHH0aIgN1-SgLvUKQAS_VL2ynLDwNrV5MU6iBB_J50wQbfSFdwISaPALYIb8aFvb715limZkLaLXUCMPPdE3iccVvlJBO7Mud6m1KMIdaOA-w-AvpHHXJ5H4N2NgQrQhdcht25IT-_cOYs1KYvyD1WieNUfGoA_gSMVEPamP8vixRi4NsLkGWSQnUZaaFX9FXfv_7ehU3iWv0u_XQQN4t3ZNODaTBih5cIuC8j6-ExBn3hAeGllrESRjP15PohvtGNYJRgJEU2J-UNZgOT9KVDobn1E9HiIhvLcqX3vHWa04g-IpVNuCd_LYupMqmVhGbhkidblCvbMwMIFX1HodejaAMBKfOYn38VzvEb6S4t56hw_9qYagUV2KYlX71SnH8RTGh8jDaFZogqTBwEjV-zz_hOe_be5UOlG5EXOeDsPR_XkP3VNc03IrmpXu6VEKZWbK87CWcKAJaZa8bSYC4FpHMyKM2l847Ns6XO3WgNZJMCHnJtc4hh0x9D2UFXlXqTa5DkrY"
                    ,CreateOrderRequest(work_id,details,details_address,photos,phone,lat,long))

                val createOrderResponse = response.body()
                if (response.isSuccessful) {

//                    loginResponse?.success == true

//                    if (loginResponse?.data?.token.toString() != null) {
                    if (createOrderResponse?.success == true) {
                        // تم تسجيل الدخول بنجاح، يمكنك حفظ الرمز المميز والانتقال إلى الشاشة التالية
                        val message = createOrderResponse?.message
                        Log.d("ll","تم تسجيل الدخول")
                        Log.d("ll","Token : "+message.toString())
                        navigation.navigate("CardInfoFilledScreen") {
                                popUpTo(navigation.graph.id) {
                                    inclusive = true
                                }
                            }
                        Toast.makeText(context,"تم إضافة الطلب بنجاح",Toast.LENGTH_SHORT).show()
                    } else {
                        // فشل تسجيل الدخول، عرض رسالة خطأ
                        Toast.makeText(context,createOrderResponse?.message,Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // فشل تسجيل الدخول، عرض رسالة خطأ
                    Toast.makeText(context,createOrderResponse?.message,Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // التعامل مع الأخطاء التي تتعلق بالشبكة أو الخدمة
                Log.d("ll",e.message.toString())
                Toast.makeText(context,e.message.toString(),Toast.LENGTH_SHORT).show()
            }
        }


//        viewModelScope.launch {
//            try {
//                val apiLogin = ApiLogin.getInstance()
//                val response = apiLogin.login(LoginRequest(username, password))
//
//                if (response.isSuccessful) {
//                    val loginResponse = response.body()
//
//                    if (loginResponse?.name != null) {
//                        // تم تسجيل الدخول بنجاح، يمكنك حفظ الرمز المميز والانتقال إلى الشاشة التالية
//                        val token = loginResponse.token
//                        Log.d("ll","تم تسجيل الدخول")
//                        Log.d("ll",token.toString())
////                        Toast.makeText(
////                            context,
////                            "Authentication failed.",
////                            Toast.LENGTH_SHORT
////                        ).show()
//                    } else {
//                        // فشل تسجيل الدخول، عرض رسالة خطأ
//                        // تم تسجيل الدخول بنجاح، يمكنك حفظ الرمز المميز والانتقال إلى الشاشة التالية
//                        Log.d("ll","لم تسجيل الدخول111111")
//                    }
//                } else {
//                    // فشل تسجيل الدخول، عرض رسالة خطأ
//                    Log.d("ll","لم تسجيل الدخول222222222")
//                }
//            } catch (e: Exception) {
//                // التعامل مع الأخطاء التي تتعلق بالشبكة أو الخادم
//                Log.d("ll",e.message.toString())
//            }
//        }


    }









//    private val _loginResult :MutableLiveData<Result<Login>>()
//    val loginResult: LiveData<Result<Login>> get() = _loginResult
//
//    fun login(username: String, password: String) {
//        viewModelScope.launch {
//            _loginResult.value = Result.Loading
//
//            val result = ApiLogin.getInstance().PostLogin(username, password)
//
//            _loginResult.value = result
//        }
//    }


//    fun postLogin(email : String,password : Int){
//        viewModelScope.launch {
//            val apiLogin = ApiLogin.getInstance()
//
//            val login = apiLogin.PostLogin(email,password)
////            loginResponse = login.isSuccessful
//            if (login.isSuccessful){
//                val loginResponse = login.body()
//                if (loginResponse != null) {
//                    return Result.Success(loginResponse)
//                }
//            }
//
//            return Result.Error(Exception("Login failed"))
//        }
//    }

}