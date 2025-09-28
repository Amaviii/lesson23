package com.example.lesson23.data

import com.example.lesson23.domain.FilterRepository
import com.example.lesson23.domain.StudentEntity

class FilterRepositoryImpl : FilterRepository {
    override fun getPersons(): List<StudentEntity> {
        return listOf(
            StudentEntity("Alex", 0),
            StudentEntity("Boba", 1),
            StudentEntity("Ivan", 2),
            StudentEntity("Alix", 3),
        )
    }
}