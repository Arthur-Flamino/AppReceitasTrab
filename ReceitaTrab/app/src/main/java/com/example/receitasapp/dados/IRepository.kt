package com.example.receitasapp.dados

import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun listarTodasReceita(): Flow<List<Receita>>
    suspend fun buscarReceitaId(idx: Int): Receita?
    suspend fun gravarReceita(receita: Receita)

}