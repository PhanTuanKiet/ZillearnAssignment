package com.example.zillearnassignment.network.response

data class CoursesResponse(
    var courses : List<CourseDetail>,
    var count : Int? = 0
)