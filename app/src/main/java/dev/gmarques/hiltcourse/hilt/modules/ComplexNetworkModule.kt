package dev.gmarques.hiltcourse.hilt.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.gmarques.hiltcourse.network.injecao_tipo_complexo.NetworkService

/**
 * Autor: Gilian
 * Data de Criação: 20/02/2025
 */
@Module
@InstallIn(ActivityComponent::class) //Torna a  implementação dessa classe disponivel para todas as activities com o @AndroidEntryPoint
class ComplexNetworkModule {

    @Provides
            /**
             * Entrega ao Hilt uma instancia de objeto 'complexo' para que ele a injete onde necessário
             * */
    fun provideNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host("myhost.com")
            .protocol("HTTPS")
            .build()

    }
}