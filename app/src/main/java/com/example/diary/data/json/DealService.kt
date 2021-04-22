package com.example.diary.data.json

import android.content.Context
import com.example.diary.data.entities.Deal
import com.example.diary.data.entities.DealsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DealService {
    @GET("character")
    suspend fun getAllDeals(context: Context) : Response<DealsList>

    @GET("character/{id}")
    suspend fun getDeal(@Path("id") id: Int, context: Context): Response<Deal>
}