package com.example.diary.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.diary.utils.Resource
import com.example.diary.utils.Resource.Status.*
import kotlinx.coroutines.Dispatchers

fun <T, A> performGetOperation(jsonCall: suspend () -> Resource<A>
                              ): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())

        val responseStatus = jsonCall.invoke()
        if (responseStatus.status == ERROR) {
            emit(Resource.error(responseStatus.message!!))
        }
    }