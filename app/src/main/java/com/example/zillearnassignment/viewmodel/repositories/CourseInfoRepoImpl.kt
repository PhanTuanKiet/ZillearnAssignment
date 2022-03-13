package com.example.zillearnassignment.viewmodel.repositories

import com.example.zillearnassignment.model.response.CourseInfoResponse
import com.example.zillearnassignment.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class CourseInfoRepoImpl @Inject constructor(private val apiService: ApiService) : CourseInfoRepository {

    override fun getCourseInfo(id: String): Observable<CourseInfoResponse> {
        return apiService.getCourseInfo(id)
    }


}