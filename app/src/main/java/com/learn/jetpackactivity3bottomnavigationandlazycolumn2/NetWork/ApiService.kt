package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.NetWork

import androidx.compose.runtime.State
import com.example.example.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @GET("all/works")
    suspend fun getService():ExampleJson2KtKotlin

    @POST("auth/login/user")
    suspend fun login(@Body request: LoginRequest): Response<ExampleJson2KtKotlinLogin>

    @POST("create/order")
    suspend fun createOrder(@Header("Authorization") token: String, @Body request: CreateOrderRequest): Response<ExampleJson2KtKotlinCreateOreder>

    @GET("order/complete/user")
    suspend fun getOrderComplete(@Header("Authorization") token: String,): ExampleJson2KtKotlinUnComplete

    @GET("order/pending/user")
    suspend fun getOrderPending(@Header("Authorization") token: String,):ExampleJson2KtKotlinUnComplete

    @GET("order/un/complete/user")
    suspend fun getOrderUnComplete(@Header("Authorization") token: String,):ExampleJson2KtKotlinUnComplete

    @POST("auth/register/user")
    suspend fun register(@Body request: RegisterRequest): Response<ExampleJson2KtKotlinRegister>


    companion object{
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://studentucas.awamr.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().addInterceptor(JsonHeaderInterceptor()).build())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}

data class LoginRequest(val email: String, val password: String)

data class LoginResponse(val token: String?)

data class RegisterRequest(val name: String, val email: String,
                           val password: String, val phone: String)

data class CreateOrderRequest(
    val work_id: String, val details: String
    , val details_address: String, val photos: List<State<Any>>
    , val phone: String, val lat: String, val long: String)

class JsonHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request().newBuilder()
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(request)
    }
}