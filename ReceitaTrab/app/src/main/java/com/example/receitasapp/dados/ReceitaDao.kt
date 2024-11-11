package com.example.receitasapp.dados

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceitaDao {

    //Listar
    @Query("select * from receita")
    fun listaTodasReceita(): Flow<List<Receita>>

    //Listar Favorito
    @Query("select * from receita where ehFavorito = true")
    fun listaReceitaFavorita(): Flow<List<Receita>>

    //Listar Feito
    @Query("select * from receita where ehFeito = true")
    fun listaReceitaFeita(): Flow<List<Receita>>


}