package com.example.receitasapp.dados

import kotlinx.coroutines.flow.Flow

class LocalRepositorio(
    private val dao: ReceitaDao
): IRepository {

    override fun listarTodasReceita(): Flow<List<Receita>>{
        return dao.listaTodasReceita()
    }

    override suspend fun buscarReceitaId(idx: Int): Receita?{
        return dao.buscarReceitaId(idx)
    }

    override suspend fun gravarReceita(receita: Receita){
        return dao.gravarReceita(receita)
    }
}