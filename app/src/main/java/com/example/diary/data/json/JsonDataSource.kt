package com.example.diary.data.json

import android.content.Context
import com.example.diary.data.entities.Deal
import com.google.gson.Gson
import java.lang.Exception

class JsonDataSource {
companion object {
    fun getAllDeals(): List<Deal>? {
        val deals: List<Deal>
        try {
         deals = Gson()
            .fromJson(JsonFile.jsonString, Array<Deal>::class.java)
            .toList()}
        catch (e: Exception) {
            return null
        }
        return deals
    }
   fun getDeal(id: Int): Deal? {
       val deals = getAllDeals()
       for (deal: Deal in deals!!) {
           if (id == deal.id) {
               return deal
           }
       }
       return null
    }
}
}