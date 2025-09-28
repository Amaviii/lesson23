package com.example.lesson23.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson23.data.FilterRepositoryImpl
import com.example.lesson23.domain.FilterInteractor
import com.example.lesson23.domain.StudentEntity

class CountViewModel: ViewModel() {

    private val _count = MutableLiveData<List<StudentEntity>>(listOf())
    val count get() = _count

    private val filterInteractor = FilterInteractor(filterRepository = FilterRepositoryImpl())

    fun touchButton(text: String) {
        _count.value = filterInteractor.getFilteredStudents(text).map {
            StudentEntity(it.name, it.id, it.rating)
        }
    }
}