package com.alexkarav.boredapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


/*
* Класс базы данных
* */
@Database(entities = [ActivityEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): BoredDao
}