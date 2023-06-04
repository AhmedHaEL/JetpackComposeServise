package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.NetWork.*
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterViewModel() : ViewModel() {

    fun performLogin( name: String,  email: String,
                      password: String,  phone: String,
                     navigation: NavController,context : Context) {

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://studentucas.awamr.com/api/") // استبدل هذا بعنوان URL الخاص بالخادم الخاص بك
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(OkHttpClient.Builder().addInterceptor(JsonHeaderInterceptor()).build())
//            .build()
//
//        val apiLogin = retrofit.create(ApiLogin::class.java)

        val apiRegister = ApiService.getInstance()
        viewModelScope.launch {
            try {

                val response = apiRegister.register(RegisterRequest(name,email,password,phone))

                val loginResponse = response.body()
                if (response.isSuccessful) {

//                    loginResponse?.success == true

//                    if (loginResponse?.data?.token.toString() != null) {
                    if (loginResponse?.success == true) {
                        // تم تسجيل الدخول بنجاح، يمكنك حفظ الرمز المميز والانتقال إلى الشاشة التالية
                        val token = loginResponse?.data?.token
                        Log.d("ll","تم تسجيل الدخول")
                        Log.d("ll","Token : "+token.toString())
                        navigation.navigate("BottomScreen") {
                                popUpTo(navigation.graph.id) {
                                    inclusive = true
                                }
                            }
                        Toast.makeText(context,loginResponse.message.toString(),Toast.LENGTH_SHORT).show()
                    } else {
                        // فشل تسجيل الدخول، عرض رسالة خطأ
                        Toast.makeText(context,loginResponse?.message,Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // فشل تسجيل الدخول، عرض رسالة خطأ
                    Toast.makeText(context,loginResponse?.message,Toast.LENGTH_SHORT).show()
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