package dev.gmarques.hiltcourse

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.gmarques.hiltcourse.database.DatabaseAdapter
import dev.gmarques.hiltcourse.hilt.qualifiers.CallInterceptor
import dev.gmarques.hiltcourse.hilt.qualifiers.NetworkAdapterBing
import dev.gmarques.hiltcourse.hilt.qualifiers.NetworkAdapterGoogle
import dev.gmarques.hiltcourse.hilt.qualifiers.ResponseInterceptor
import dev.gmarques.hiltcourse.network.injecao_tipo_complexo.Interceptor
import dev.gmarques.hiltcourse.network.injecao_tipo_complexo.NetworkService
import dev.gmarques.hiltcourse.network.injecao_tipo_simples.NetworkAdapter
import javax.inject.Inject

private const val s = "through a  Qualifier injection"

@AndroidEntryPoint // necessário p/ criar injeçoes nessa classe
class MainActivity : AppCompatActivity() {

    @Inject
    /**
     * Injeção de campo (Field Injection) é o mais comumente usado
     * */
    lateinit var databaseAdapter: DatabaseAdapter

    @Inject
    /**
     * Ilustra uma injeção de interface
     *  @see SimpleNetworkModule
     */
    lateinit var networkAdapter: NetworkAdapter

    @Inject
    /**
     * Ilustra uma injeção de tipo complexo como uma classe com padrao Builder por exemplo
     * @see ComplexNetworkModule
     */
    lateinit var networkService: NetworkService

    @NetworkAdapterGoogle
    /** Ilustra como injetar instancias de mesmo tipo, ou diferentes implementações da mesma interface
     * @see Qualifiers (em hilt/qualifiers)
     * @see ComplexNetworkModuleWithQualifiers
     * */
    @Inject
    lateinit var networkServiceGoogle: NetworkService

    @NetworkAdapterBing
    @Inject
    lateinit var networkServiceBing: NetworkService

    @ResponseInterceptor
    @Inject
    lateinit var responseInterceptor: Interceptor

    @CallInterceptor
    @Inject
    lateinit var callInterceptor: Interceptor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("USUK", "MainActivity.onCreate: --------------- Injeçao de campo ----------------")

        databaseAdapter.log("teste de Injeçao de campo")

        Log.d("USUK", "MainActivity.onCreate: --------------- Injeçao de interface ----------------")

        networkAdapter.log("chamando funçao da implementaçao de interface na mainactivity")

        Log.d("USUK", "MainActivity.onCreate: --------------- Injeçao de tipo complexo ----------------")

        networkService.performNetworkCall()

        Log.d("USUK", "MainActivity.onCreate: --------------- Injeçao de tipo complexo com qualificador ----------------")

        networkServiceGoogle.performNetworkCall()
        networkServiceBing.performNetworkCall()
        callInterceptor.log("callInterceptor called through a  Qualifier injection")
        responseInterceptor.log("responseInterceptor called through a  Qualifier injection")

    }

    @Inject
            /**
             * Injeçao de metodo. Essa função é chamada imediatamente após a instancia de
             * @See DatabaseAdapter ser injetada pelo Hilt, isso acontece antes do oncreate.
             * Raramente usado.
             * */
    fun directToDatabase(databaseAdapter: DatabaseAdapter) {
        Log.d("USUK", "MainActivity.onCreate: --------------- Injeçao de metodo ----------------")
        databaseAdapter.log("teste de Injeçao de metodo")
    }
}