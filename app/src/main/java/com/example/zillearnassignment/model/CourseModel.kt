package com.example.zillearnassignment.model


data class CourseModel(
    var id : String,
    var title: String,
    var cover: String? = "",
    var description: String,
    var categories: String,
    var price: Float,
    var views: Int
)