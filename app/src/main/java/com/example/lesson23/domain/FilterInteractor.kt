package com.example.lesson23.domain

class FilterInteractor(val filterRepository: FilterRepository) {

    fun getFilteredStudents(text: String): List<StudentEntity> {
        return filterRepository.getPersons().filter {
            it.name.contains(text)
        }
    }
}