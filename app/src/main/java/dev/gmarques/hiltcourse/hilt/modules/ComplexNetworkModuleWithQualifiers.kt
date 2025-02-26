package dev.gmarques.hiltcourse.hilt.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.gmarques.hiltcourse.hilt.qualifiers.CallInterceptor
import dev.gmarques.hiltcourse.hilt.qualifiers.NetworkAdapterBing
import dev.gmarques.hiltcourse.hilt.qualifiers.NetworkAdapterGoogle
import dev.gmarques.hiltcourse.hilt.qualifiers.ResponseInterceptor
import dev.gmarques.hiltcourse.network.injecao_tipo_complexo.CallInterceptorImpl
import dev.gmarques.hiltcourse.network.injecao_tipo_complexo.Interceptor
import dev.gmarques.hiltcourse.network.injecao_tipo_complexo.NetworkService
import dev.gmarques.hiltcourse.network.injecao_tipo_complexo.ResponseInterceptorImpl

/**
 * Autor: Gilian
 * Data de Criação: 20/02/2025
 */
@Module
/*Torna a  implementação dessa classe disponivel para todas as activities com o @AndroidEntryPoint
tambem é possível declarar mais de um componente como ApplicationComponent ou ViewComponent caso seja necessario, basta separa-los com uma virgula.*/
@InstallIn(ActivityComponent::class)
class ComplexNetworkModuleWithQualifiers {


    @Provides
    @NetworkAdapterGoogle
            /**
             * Entrega ao Hilt uma instancia de objeto 'complexo' com uma configuração especifica
             * usando um qualificador (anotação) para que seja possivel diferenciar de outras
             * instancias do mesmo objeto.
             *
             * Nesse caso é retornado um objeto 'complexo' que pode ser um classe de terceiros com configurações
             * especificas como o retrofit por exemplo
             * */
    fun provideNetworkServiceGoogle(): NetworkService {
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .interceptor(CallInterceptorImpl())
            .build()

    }


    @Provides
    @NetworkAdapterBing
    fun provideNetworkServiceBing(): NetworkService {
        return NetworkService.Builder()
            .host("bing.com")
            .protocol("HTTPS")
            .interceptor(CallInterceptorImpl())
            .build()

    }


    @Provides
    @CallInterceptor
            /**
             * Aqui o objeto retornado é a implementaçao de uma interface
             * */
    fun provideCallNetworkService(): Interceptor {
        return CallInterceptorImpl()
    }


    @Provides
    @ResponseInterceptor
            /**
             * Já aqui é outra implementaçao da mesma interface
             * */
    fun provideResponseNetworkService(): Interceptor {
        return ResponseInterceptorImpl()
    }
}