package com.example.diary.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Deal(
    @SerializedName("id") val id : Int,
    @SerializedName("date_start") var dateStart : String,
    @SerializedName("date_finish") var dateFinish : String,
    @SerializedName("name") val name : String,
    @SerializedName("description") var description : String

)