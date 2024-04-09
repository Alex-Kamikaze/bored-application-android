package com.alexkarav.boredapplication.di

import android.content.Context
import androidx.room.Room
import com.alexkarav.boredapplication.data.api.BoredApi
import com.alexkarav.boredapplication.data.db.AppDatabase
import com.alexkarav.boredapplication.domain.BoredApplicationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/*
* Синглтон объект, из которого в остальные части приложения подключаются объекты из слоя Model
* Здесь используется Dagger Hilt, подробнее про оный - https://dev.to/anesabml/dagger-hilt-basics-23g8
* */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideBoredApi(): BoredApi {
        return Retrofit
            .Builder()
            .baseUrl(BoredApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BoredApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "app_database.sqlite")
            .build();
    }

    @Provides
    @Singleton
    fun provideAppRepo(boredApi: BoredApi, appDatabase: AppDatabase): BoredApplicationRepositoryImpl {
        return BoredApplicationRepositoryImpl(appDatabase, boredApi)
    }
}