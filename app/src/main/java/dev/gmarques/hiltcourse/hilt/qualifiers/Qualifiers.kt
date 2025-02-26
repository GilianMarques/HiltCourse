package dev.gmarques.hiltcourse.hilt.qualifiers

import javax.inject.Qualifier

/**
 * Autor: Gilian
 * Data de Criação: 25/02/2025
 *
 * Aqui se declara os Qualificadores que permitiram escolher entre as implementações de mesmo objeto na hora de
 * prover instancias com o hilt
 * @see ComplexNetworkModuleWithQualifiers
 *
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CallInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ResponseInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NetworkAdapterGoogle

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NetworkAdapterBing