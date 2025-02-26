package dev.gmarques.hiltcourse.network.injecao_tipo_complexo

import android.util.Log
import javax.inject.Inject

/**
 * Autor: Gilian
 * Data de Criação: 20/02/2025
 */
class ResponseInterceptorImpl @Inject constructor() : Interceptor {

    override fun log(msg: String) {
        Log.d("USUK", "ResponseInterceptorImpl.".plus("log() msg = $msg"))
    }
}