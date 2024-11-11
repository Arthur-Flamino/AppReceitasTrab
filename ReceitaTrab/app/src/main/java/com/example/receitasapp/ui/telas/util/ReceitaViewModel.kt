package com.example.receitasapp.ui.telas.util

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

    // Lista de receitas feitas
    private val _feitasReceitas = MutableStateFlow<List<Receita>>(emptyList())
    val feitasReceitas: StateFlow<List<Receita>> get() = _feitasReceitas

    // Lista de receitas favoritas
    private val _favoritasReceitas = MutableStateFlow<List<Receita>>(emptyList())
    val favoritasReceitas: StateFlow<List<Receita>> get() = _favoritasReceitas

    // Flags para controlar quando mostrar as listas feitas e favoritas
    private val _mostrarFeitas = MutableStateFlow(false)
    val mostrarFeitas: StateFlow<Boolean> get() = _mostrarFeitas

    private val _mostrarFavoritas = MutableStateFlow(false)
    val mostrarFavoritas: StateFlow<Boolean> get() = _mostrarFavoritas

    init {
        // Coletando todas as receitas
        viewModelScope.launch {
            repository.listarTodasReceita().collectLatest { listaDeTodasReceitas ->
                _todasReceitas.value = listaDeTodasReceitas
            }
        }

        // Coletando as receitas feitas
        viewModelScope.launch {
            repository.listaReceitaFeita().collectLatest { listaFeitaReceitas ->
                _feitasReceitas.value = listaFeitaReceitas
            }
        }

        // Coletando as receitas favoritas
        viewModelScope.launch {
            repository.listaReceitaFavorita().collectLatest { listaFavReceitas ->
                _favoritasReceitas.value = listaFavReceitas
            }
        }
    }

    // Métodos para ativar/desativar a visualização das listas feitas e favoritas
    fun toggleMostrarFeitas() {
        _mostrarFeitas.value = !_mostrarFeitas.value
    }

    fun toggleMostrarFavoritas() {
        _mostrarFavoritas.value = !_mostrarFavoritas.value
    }
}


