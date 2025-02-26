package dev.gmarques.hiltcourse.database

import android.util.Log
import javax.inject.Inject

/**
 * Autor: Gilian
 * Data de Criação: 18/02/2025
 * Colocar o @Inject no construtor torna essa classe disponivel no grafico de dependencias do hilt
 * para que possa ser injetada em outras classes
 */
class DatabaseService  @Inject constructor(){
    
    fun log (msg:String){
        Log.d("USUK", "DatabaseService.log: $msg")
    }
    
}