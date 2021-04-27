package com.example.diary.data.repository

import android.content.Context
import com.example.diary.data.entities.Deal
import com.example.diary.data.json.JsonDataSource

import javax.inject.Inject

class DealRepository  {

    companion object {
        //будет добавлен performGetOperation для отображения ресурсов из наиболее оптимального источника
        fun getAllDeals(): List<Deal>? {
            return JsonDataSource.getAllDeals()
        }
    }
}