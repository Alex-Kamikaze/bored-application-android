package com.alexkarav.boredapplication.domain

import com.alexkarav.boredapplication.data.BoredApplicationRepository
import com.alexkarav.boredapplication.data.api.BoredApi
import com.alexkarav.boredapplication.data.db.ActivityEntity
import com.alexkarav.boredapplication.data.db.AppDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
* Имплементация репозитория
* */
class BoredApplicationRepositoryImpl @Inject constructor(val appDatabase: AppDatabase, val boredApi: BoredApi): BoredApplicationRepository {
    private val dao = appDatabase.getDao()
    override suspend fun upsertActivities(vararg activityEntity: ActivityEntity) {
        dao.upsertActivities(*activityEntity)
    }

    override suspend fun deleteActivities(vararg activityEntity: ActivityEntity) {
        dao.deleteActivities(*activityEntity)
    }

    override suspend fun getActivities(): Flow<List<ActivityEntity>> {
        // Есть интернет - данные качаются с апишки и кэшируются в базе данных
        // Нет инета - данные достаются из базы
        try {
            val apiResponse = boredApi.getRandomActivity()
            val newActivity = ActivityEntity(
                activityName = apiResponse.activity,
                activityType = apiResponse.type,
                participants = apiResponse.participants,
                price = apiResponse.price.toFloat(),
                accessibility = apiResponse.accessibility,
                key = apiResponse.key,
                link = apiResponse.link
            )
            dao.upsertActivities(newActivity)
            return dao.getAllActivities()
        }
        catch(ex: Exception) {
            return dao.getAllActivities()
        }
    }
}