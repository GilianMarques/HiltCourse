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
/*Torna a  implementação dessa classe disponivel para todas as activities com o @AndroidEntryPoint
tambem é possível declarar mais de um componente como ApplicationComponent ou ViewComponent caso seja necessario, basta separa-los com uma virgula.*/
@InstallIn(ActivityComponent::class)
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