package com.example.receitasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.receitasapp.dados.LocalRepositorio
import com.example.receitasapp.dados.ReceitaDataBase.ReceitaDatabase.Companion.abrirBancoDados
import com.example.receitasapp.dados.RemoteRepository
import com.example.receitasapp.ui.telas.util.ReceitaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = abrirBancoDados(this)
        val local = LocalRepositorio(db.receitaDao())
        val remoto = RemoteRepository()
        val viewModel = ReceitaViewModel(remoto)

        setContent {
            ReceitaController(viewModel)
        }
    }
}

