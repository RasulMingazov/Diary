package com.example.diary.data.repository

import android.content.Context
import com.example.diary.data.entities.Deal
import com.example.diary.data.json.DealJsonDataSource
import com.example.diary.utils.performGetOperation
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val jsonDataSource: DealJsonDataSource
)

    fun getDeal(id: Int): Single<Deal> {


    fun getDeals(context: Context) = performGetOperation(
        jsonCall = { jsonDataSource.getDeals(context) }
    )
}