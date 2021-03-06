package com.example.zillearnassignment.network.response

data class CourseInfo(
    var courseResponse : CourseDetail,
    var description: String,
    var categories: List<Categories>,
    var views: Int,
    var duration: Int
)