package dev.gmarques.hiltcourse.network.injecao_tipo_simples

/**
 * Autor: Gilian
 * Data de Criação: 20/02/2025
 *
 * Serve para ilustrar como injetar uma interface (sua implementação, na vdd) simples usando um modulo
 * @see NetworkModule
 * @see NetworkAdapterImpl
 *
 */
interface NetworkAdapter {

    fun log(msg: String)

}