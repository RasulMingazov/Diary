package com.example.diary.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

data class Deal(
    @PrimaryKey
    val id: Int,
    val date_start: Timestamp,
    val date_finish: Timestamp,
    val name: String,
    val description: String
)