package com.example.receitasapp.dados

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceitaDao {

    //Listar
    @Query("select * from receita")
    fun listaTodasReceita(): Flow<List<Receita>>

    //Buscar por id
    @Query("select * from receita where id = :idx")
    fun buscarReceitaId(idx: Int):  Receita

    //adicionar receita
    @Upsert
    fun gravarReceita(receita: Receita)


}