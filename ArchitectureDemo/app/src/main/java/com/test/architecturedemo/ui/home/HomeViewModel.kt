package com.test.architecturedemo.ui.home

import androidx.lifecycle.MutableLiveData
import com.test.architecturedemo.domain.MyUseCase
import com.test.architecturedemo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeViewModel (private val myUseCase: MyUseCase): BaseViewModel() {
    val items = MutableLiveData<List<String>>()

    fun setList(){
        items.value = listOf("One", "Two", "Three", "Two", "Three", "Two",
            "Three", "Two", "Three", "Two", "Three", "Two", "Three")
    }

    fun getList(){
        executeUseCase("", myUseCase, onSuccess = {

        }, onError = {

        })
    }
}