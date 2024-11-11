package com.example.receitasapp.dados

import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun listarTodasReceita(): Flow<List<Receita>>
    fun listaReceitaFavorita(): Flow<List<Receita>>
    fun listaReceitaFeita(): Flow<List<Receita>>

}