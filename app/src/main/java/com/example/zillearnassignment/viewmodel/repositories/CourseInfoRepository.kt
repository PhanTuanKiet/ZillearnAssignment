package com.example.zillearnassignment.viewmodel.repositories

import com.example.zillearnassignment.model.response.CourseInfoResponse
import io.reactivex.Observable

interface CourseInfoRepository  {

    fun getCourseInfo(id : String) : Observable<CourseInfoResponse>

}