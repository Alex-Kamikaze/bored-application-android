package com.alexkarav.boredapplication.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey


/*
* Модель таблицы в базе данных
* */
@Entity(tableName = "activities")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val activityId: Int = 0,
    val activityName: String,
    val activityType: String,
    val participants: Int,
    val price: Float,
    val link: String,
    val key: String,
    val accessibility: Double
)
