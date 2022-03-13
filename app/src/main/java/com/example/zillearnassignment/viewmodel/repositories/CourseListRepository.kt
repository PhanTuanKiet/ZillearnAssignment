package com.example.zillearnassignment.viewmodel.repositories

import com.example.zillearnassignment.network.response.CoursesResponse
import io.reactivex.Observable

interface CourseListRepository {

    fun getCourseList(size : Int, page : Int) : Observable<CoursesResponse>

}