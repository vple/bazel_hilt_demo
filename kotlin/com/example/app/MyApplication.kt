package com.example.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp(Application::class)
class MyApplication : Hilt_MyApplication()
