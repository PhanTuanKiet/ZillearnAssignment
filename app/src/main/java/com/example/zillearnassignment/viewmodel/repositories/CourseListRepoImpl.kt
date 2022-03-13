package com.example.zillearnassignment.viewmodel.repositories

import com.example.zillearnassignment.network.response.CoursesResponse
import com.example.zillearnassignment.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class CourseListRepoImpl @Inject constructor(private val apiService: ApiService) : CourseListRepository {

    override fun getCourseList(size : Int, page : Int): Observable<CoursesResponse> {
        val requestBody : HashMap<String, Int> = HashMap()
        requestBody["size"] = size
        requestBody["page"] = page
        return apiService.getCourseList(requestBody)
    }
}