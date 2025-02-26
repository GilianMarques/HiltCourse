package dev.gmarques.hiltcourse.hilt.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.gmarques.hiltcourse.network.injecao_tipo_simples.NetworkAdapterImpl
import dev.gmarques.hiltcourse.network.injecao_tipo_simples.NetworkAdapter

/**
 * Autor: Gilian
 * Data de Criação: 20/02/2025
 */
@Module
/*Torna a  implementação dessa classe disponivel para todas as activities com o @AndroidEntryPoint
tambem é possível declarar mais de um componente como ApplicationComponent ou ViewComponent caso seja necessario, basta separa-los com uma virgula.*/
@InstallIn(ActivityComponent::class)
abstract class SimpleNetworkModule {

    @Binds
    /**
     * Mostra para o hilt o que injetar quando uma instancia de NetworkAdapter for necessária
     * serve  pra ilustrar uma injeçao da implementação de uma interface simples que
     * é feita com o @Inject no construtor
     * @see NetworkAdapter
     * @see NetworkAdapterImpl
     * */
    abstract fun bindNetworkAdapterImpl(networkAdapterImpl: NetworkAdapterImpl): NetworkAdapter
}