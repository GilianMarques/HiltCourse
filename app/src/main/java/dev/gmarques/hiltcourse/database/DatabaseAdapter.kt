package dev.gmarques.hiltcourse.database

import android.util.Log
import javax.inject.Inject

/**
 * Autor: Gilian
 * Data de Criação: 18/02/2025
 *
 * Exemplo de injeção de construtor
 */
class DatabaseAdapter @Inject constructor(private var databaseService: DatabaseService) {

    fun log(msg: String) {
        Log.d("USUK", "DatabaseAdapter.log: $msg")
        databaseService.log(msg)
    }
}