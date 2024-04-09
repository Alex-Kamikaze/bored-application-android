package com.alexkarav.boredapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Контейнер для зависимостей, необходим для работы Dagger Hilt
@HiltAndroidApp
class BoredApplication: Application() {
}