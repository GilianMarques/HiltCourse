package dev.gmarques.hiltcourse

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

/**
 * Autor: Gilian
 * Data de Criação: 12/02/2025
 */
@HiltAndroidApp // ponto de entrada do hilt no app
class App : Application() {

    override fun onCreate() {
        Log.d("USUK", "App.onCreate: ")
        super.onCreate()
    }
}