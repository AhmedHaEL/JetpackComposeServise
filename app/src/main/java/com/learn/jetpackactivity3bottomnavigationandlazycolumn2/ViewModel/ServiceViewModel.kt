package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.DataServes
import com.learn.jetpackactivity3bottomnavigationandlazycolumn2.NetWork.ApiService
import kotlinx.coroutines.launch

class ServiceViewModel : ViewModel() {

    var serviceListResponse:List<DataServes> by mutableStateOf(listOf())

    fun getService(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            val serviceList = apiService.getService()
            serviceListResponse = serviceList.data
        }
    }

}