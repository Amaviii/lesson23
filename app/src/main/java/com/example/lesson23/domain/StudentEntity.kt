package com.example.lesson23.domain

data class StudentEntity(
    val name: String,
    val id: Int,
    val rating: Double = 5.0
)