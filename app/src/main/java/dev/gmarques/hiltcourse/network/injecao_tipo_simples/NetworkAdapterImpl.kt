package dev.gmarques.hiltcourse.network.injecao_tipo_simples

import android.util.Log
import javax.inject.Inject

/**
 * Autor: Gilian
 * Data de Criação: 20/02/2025
 *
 * Implementa  NetworkAdapter e é injetado pelo hilt na mainActivity como instruido no modulo NetworkModule
 * @see NetworkModule
 */
class NetworkAdapterImpl @Inject constructor() : NetworkAdapter {

    override fun log(msg: String) {
        Log.d("USUK", "NetworkAdapterImpl.".plus("log() msg = $msg"))
    }
}