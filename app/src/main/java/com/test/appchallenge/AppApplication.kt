package com.test.appchallenge

import android.app.Application
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ApplicationComponent

@HiltAndroidApp
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}