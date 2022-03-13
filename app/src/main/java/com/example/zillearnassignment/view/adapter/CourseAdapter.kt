package com.example.zillearnassignment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zillearnassignment.base.BaseAdapter
import com.example.zillearnassignment.base.BaseViewHolder
import com.example.zillearnassignment.databinding.CourseListItemBinding
import com.example.zillearnassignment.network.response.CourseDetail
import com.example.zillearnassignment.view.holder.CourseListViewHolder

class CourseAdapter(private val onClickEvent: (course: CourseDetail) -> Unit) : BaseAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = CourseListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CourseListViewHolder(binding, onClickEvent)
    }
}