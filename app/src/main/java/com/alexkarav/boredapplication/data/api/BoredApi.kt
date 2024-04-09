package com.alexkarav.boredapplication.data.api

import retrofit2.http.GET

/*
* Интерфейс, в котором описываются методы для работы с API - запросов в инет
* Здесь юзается Retrofit - https://practicum.yandex.ru/blog/retrofit-na-android/
* */
interface BoredApi {
    @GET("/api/activity/")
    suspend fun getRandomActivity(): ActivityApiModel

    companion object {
        val BASE_URL = "www.boredapi.com"
    }
}