package com.example.zillearnassignment.model.response

data class CoursesResponse(
    var courses : List<CourseDetail>,
    var count : Int? = 0
)