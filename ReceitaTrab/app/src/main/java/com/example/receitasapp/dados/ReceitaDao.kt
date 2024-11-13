package com.example.receitasapp.dados

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceitaDao {

    //Listar
    @Query("select * from receita")
    fun listaTodasReceita(): List<Receita>

    //Listar Favorito
    @Query("select * from receita where ehFavorito = true")
    fun listaReceitaFavorita(): Flow<List<Receita>>

    //Listar Feito
    @Query("select * from receita where ehFeito = true")
    fun listaReceitaFeita(): Flow<List<Receita>>


    @Query("select * from receita where id = :idx")
    fun buscarReceitaId(idx: Int):  Receita

    @Upsert
    fun gravarReceita(receita: Receita)


}