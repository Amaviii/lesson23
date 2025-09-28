package com.example.lesson23.domain

interface FilterRepository {
    fun getPersons() : List<StudentEntity>
}