package com.example.receitasapp.ui.telas.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.privacysandbox.ads.adservices.adid.AdId
import com.example.receitasapp.dados.IRepository
import com.example.receitasapp.dados.Receita
import com.example.receitasapp.dados.ReceitaDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    var receita: MutableState<Receita?> = mutableStateOf(null)
        private set

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



}


