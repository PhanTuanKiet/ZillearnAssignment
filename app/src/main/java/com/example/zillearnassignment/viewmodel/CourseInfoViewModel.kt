package com.example.zillearnassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.zillearnassignment.base.BaseViewModel
import com.example.zillearnassignment.model.CourseModel
import com.example.zillearnassignment.model.response.CourseInfo
import com.example.zillearnassignment.viewmodel.repositories.CourseInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CourseInfoViewModel @Inject constructor(
    private val repo: CourseInfoRepository
) : BaseViewModel() {

    private var courseId : String = ""
    val courseInfoData: MutableLiveData<CourseModel?> by lazy {
        MutableLiveData(null)
    }

    fun setCourseId (id : String){
        courseId = id
    }

    fun getCourseInfo() {
        val result = repo.getCourseInfo(courseId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { response ->
                    convertCourseInfoUIModel(response.courses)
                },
                { throwable ->
                    handleError(throwable)
                }
            )
        compositeDisposable.add(result)
    }

    private fun convertCourseInfoUIModel(course : CourseInfo?) {
        if (course != null) {
            val courseDetail = course.courseResponse
            val courseModel = CourseModel(
                id = courseDetail.id,
                title = courseDetail.title,
                cover = courseDetail.coverUrl,
                description = course.description,
                categories = course.categories[0].name,
                price = courseDetail.price,
                views = course.views
            )
            updateCourseInfoResult(courseModel)
        }
    }

    private fun updateCourseInfoResult(data : CourseModel){
        courseInfoData.value = data
    }

}