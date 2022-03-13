package com.example.zillearnassignment.di

import com.example.zillearnassignment.viewmodel.repositories.CourseInfoRepoImpl
import com.example.zillearnassignment.viewmodel.repositories.CourseInfoRepository
import com.example.zillearnassignment.viewmodel.repositories.CourseListRepoImpl
import com.example.zillearnassignment.viewmodel.repositories.CourseListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun getCourseListRepo(repo : CourseListRepoImpl) : CourseListRepository

    @Binds
    abstract fun getCourseInfoRepo(repo : CourseInfoRepoImpl) : CourseInfoRepository

}