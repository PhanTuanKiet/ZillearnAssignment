package com.example.zillearnassignment.model.response

data class CourseDetail(
    var id : String,
    var title: String,
    var coverUrl: String? = "",
    var rating: Float,
    var price: Float
)