package com.example.lesson23.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson23.databinding.StudentsLayoutBinding
import com.example.lesson23.domain.StudentEntity

class MyAdapter(private var students: List<StudentEntity>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: StudentsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: StudentEntity) {
            binding.tvName.text = student.name
            binding.tvRating.text = student.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = StudentsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount() = students.size

    fun updateList(newList: List<StudentEntity>) {
        val diffResult = DiffUtil.calculateDiff(
            MyCallback(
                oldList = students,
                newList = newList,
            )
        )
        students = newList
        diffResult.dispatchUpdatesTo(this)
    }
}