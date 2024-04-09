package com.alexkarav.boredapplication.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

/*
* Функции для работы с базой данных
*/
@Dao
interface BoredDao {

    @Upsert
    suspend fun upsertActivities(vararg activityEntity: ActivityEntity)

    @Delete
    suspend fun deleteActivities(vararg activityEntity: ActivityEntity)

    @Query("SELECT * FROM activities")
    fun getAllActivities(): Flow<List<ActivityEntity>>

    @Query("SELECT * FROM activities WHERE `key` = :key")
    suspend fun getActivityByKey(key: String): ActivityEntity
}