package com.example.zillearnassignment.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException

open class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    protected val apiMessageLive: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    private fun updateApiMessage(message : String) {
        apiMessageLive.value = message
    }

    protected fun handleError(e : Throwable) { //show error dialog
        var message = ""
        if(e is HttpException){
            message = e.message()
        }
        updateApiMessage(message)
        e.printStackTrace()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}