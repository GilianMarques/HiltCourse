package dev.gmarques.hiltcourse.network.injecao_tipo_complexo

import android.util.Log

/**
 * Autor: Gilian
 * Data de Criação: 20/02/2025
 *
 * Serve para ilustrar como injetar um tipo complexo
 */
class NetworkService private constructor(builder: Builder) {
    private var protocol: String?
    private var host: String?
    private var path: String?
    private var interceptor: Interceptor?

    init {
        this.protocol = builder.protocol
        this.host = builder.host
        this.path = builder.path
        this.interceptor = builder.interceptor
    }

    fun performNetworkCall(){
        interceptor?.log("call to interceptor from performNetworkCall with host=$host, protocol=$protocol")
        Log.d("USUK", "NetworkService.".plus("performNetworkCall() host=$host, protocol=$protocol "))
    }


    class Builder {

        var protocol: String? = null
            private set
        var host: String? = null
            private set
        var path: String? = null
            private set
        var interceptor: Interceptor? = null
            private set

        fun protocol(protocol: String) = apply { this.protocol = protocol }

        fun host(host: String) = apply { this.host = host }

        fun path(path: String) = apply { this.path = path }

        fun interceptor(interceptor: Interceptor) = apply { this.interceptor = interceptor }

        fun build() = NetworkService(this)
    }
}