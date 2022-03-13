package com.example.zillearnassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.zillearnassignment.base.BaseViewModel
import com.example.zillearnassignment.network.response.CourseDetail
import com.example.zillearnassignment.viewmodel.repositories.CourseListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CourseListViewModel @Inject constructor(
    private val repo: CourseListRepository
) : BaseViewModel() {

    val courseResultData: MutableLiveData<List<CourseDetail>?> by lazy {
        MutableLiveData(null)
    }

    fun getCourseList() {
        val result = repo.getCourseList(8, 0)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { response ->
                    updateCourseListResult(response.courses)
                },
                { throwable ->
                    handleError(throwable)
                }
            )
        compositeDisposable.add(result)
    }

    private fun updateCourseListResult(listData: List<CourseDetail>){
        courseResultData.value = listData
    }

}