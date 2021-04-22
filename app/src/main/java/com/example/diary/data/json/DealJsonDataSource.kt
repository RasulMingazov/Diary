package com.example.diary.data.json

import android.content.Context
import javax.inject.Inject

class DealJsonDataSource @Inject constructor(
 private val dealService: DealService,
 private val context: Context
): BaseDataSource() {

 suspend fun getDeals(context: Context) = getResult { dealService.getAllDeals(context) }
 suspend fun getDeal(id: Int, context: Context) = getResult { dealService.getDeal(id, context) }
}