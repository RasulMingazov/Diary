package com.example.diary.ui.deals

import androidx.lifecycle.ViewModel
import com.example.diary.data.repository.DealRepository

class DealsViewModel : ViewModel() {
    val deals = DealRepository.getAllDeals()
}
