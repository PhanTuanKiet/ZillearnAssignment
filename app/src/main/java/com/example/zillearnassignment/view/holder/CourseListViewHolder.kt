package com.example.zillearnassignment.view.holder

import com.example.zillearnassignment.base.BaseAdapter
import com.example.zillearnassignment.base.BaseViewHolder
import com.example.zillearnassignment.databinding.CourseListItemBinding
import com.example.zillearnassignment.network.response.CourseDetail

class CourseListViewHolder(
    itemView: CourseListItemBinding,
    private val onClickEvent: (data: CourseDetail) -> Unit
) : BaseViewHolder(itemView.root) {
    private val binding: CourseListItemBinding = itemView

    override fun setData(data: Any?, position: Int, adapter: BaseAdapter) {
        if (data is CourseDetail) {
            buildUIText(data)
            buildOnCLickEvent(data)
        }
    }

    private fun buildUIText(data: CourseDetail) {
        binding?.tvCourseTitle.text = data.title
    }

    private fun buildOnCLickEvent(data : CourseDetail){
        binding.root.setOnClickListener {
            onClickEvent(data)
        }
    }


}