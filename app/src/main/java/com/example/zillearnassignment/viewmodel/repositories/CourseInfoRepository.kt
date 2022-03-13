package com.example.zillearnassignment.viewmodel.repositories

import com.example.zillearnassignment.network.response.CourseInfoResponse
import io.reactivex.Observable

interface CourseInfoRepository  {

    fun getCourseInfo(id : String) : Observable<CourseInfoResponse>

}