package com.alexkarav.boredapplication.data

import com.alexkarav.boredapplication.data.api.ActivityApiModel
import com.alexkarav.boredapplication.data.db.ActivityEntity
import kotlinx.coroutines.flow.Flow


/*
* Описание функций для репозитория
* Подробнее про паттерн репозитория - https://swiftbook.ru/post/tutorials/repository-pattern-with-jetpack-compose/
* */
interface BoredApplicationRepository {
    suspend fun upsertActivities(vararg activityEntity: ActivityEntity)
    suspend fun deleteActivities(vararg activityEntity: ActivityEntity)
    suspend fun getActivities(): Flow<List<ActivityEntity>>
}