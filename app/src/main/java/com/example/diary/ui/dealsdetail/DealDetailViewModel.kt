package com.example.diary.ui.dealsdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.diary.data.entities.Deal
import com.example.diary.data.repository.DealRepository

class DealDetailViewModel: ViewModel() {

    private val _id = MutableLiveData<Int>()

    var deal: Deal? = null
    fun start(id: Int) {
        _id.value = id
        deal = DealRepository.getDeal(id)
    }

}