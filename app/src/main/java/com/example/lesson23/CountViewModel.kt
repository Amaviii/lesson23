package com.example.lesson23

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    private val _count = MutableLiveData<Int>(0)
    val count get() = _count

    fun touchButton() {
        _count.value = _count.value?.plus(1)
    }
}