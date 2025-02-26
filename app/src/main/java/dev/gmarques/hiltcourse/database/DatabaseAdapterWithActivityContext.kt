package dev.gmarques.hiltcourse.database

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/**
 * Autor: Gilian
 * Data de Criação: 18/02/2025
 *
 * Exemplo de como injetar um contexto de activity em um objeto.
 * O qualidficador '@ActivityContext' é predefinido no Hilt, nao sendo necessario cria-lo.
 */
class DatabaseAdapterWithActivityContext @Inject constructor(
    @ActivityContext private var context: Context,
    private var databaseService: DatabaseService,
) {

    init {
        Log.d("USUK", "DatabaseAdapterWithActivityContext.: context available $context''")
    }

    fun log(msg: String) {
        Log.d("USUK", "DatabaseAdapter.log: $msg")
        databaseService.log(msg)
    }
}