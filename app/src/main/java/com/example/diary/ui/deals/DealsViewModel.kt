package com.example.diary.ui.deals

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diary.data.json.JsonDataSource
import com.example.diary.data.repository.DealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DealsViewModel @ViewModelInject constructor(
) : ViewModel() {
    val deals = DealRepository.getAllDeals()
}
