package com.example.receitasapp.ui.telas.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.receitasapp.dados.IRepository
import com.example.receitasapp.dados.Receita
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ReceitaViewModel(
    private val repository: IRepository
) : ViewModel() {

    // Lista principal com todas as receitas
    private val _todasReceitas = MutableStateFlow<List<Receita>>(emptyList())
    val todasReceitas: StateFlow<List<Receita>> get() = _todasReceitas


    init {
        // Coletando todas as receitas
        viewModelScope.launch {
            repository.listarTodasReceita().collectLatest { listaDeTodasReceitas ->
                _todasReceitas.value = listaDeTodasReceitas
            }
        }

    }

    private val _receita = mutableStateOf<Receita?>(null)
    val receita: MutableState<Receita?> = mutableStateOf(null)

    suspend fun buscarReceitaId(id: Int) {
        viewModelScope.launch {
            receita.value = repository.buscarReceitaId(id)
        }
    }


    fun gravarReceita(receita: Receita) {
        viewModelScope.launch {
            repository.gravarReceita(receita)
        }
    }

    fun atualizarFavorito(receita: Receita) {
        viewModelScope.launch {
            receita.ehFavorito = !receita.ehFavorito
            repository.gravarReceita(receita)
            _receita.value = receita
        }
    }

    fun atualizarFeito(receita: Receita) {
        viewModelScope.launch {
            receita.ehFeito = !receita.ehFeito
            repository.gravarReceita(receita)
            _receita.value = receita
        }
    }



}


