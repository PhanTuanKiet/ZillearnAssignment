package com.example.zillearnassignment.network

import com.example.zillearnassignment.model.response.CourseDetail
import com.example.zillearnassignment.model.response.CourseInfo
import com.example.zillearnassignment.model.response.CourseInfoResponse
import com.example.zillearnassignment.model.response.CoursesResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.HashMap

interface ApiService {

    @POST("latest")
    fun getCourseList(
        @Body requestBody : HashMap<String, Int>
    ): Observable<CoursesResponse>

    @GET("introduction")
    fun getCourseInfo(
        @Query("courseId") courseId :String,
    ): Observable<CourseInfoResponse>

}