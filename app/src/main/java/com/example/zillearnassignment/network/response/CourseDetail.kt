package com.example.zillearnassignment.network.response

data class CourseDetail(
    var id : String,
    var title: String,
    var coverUrl: String? = "",
    var rating: Float,
    var price: Float
)