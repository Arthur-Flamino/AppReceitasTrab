package com.example.receitasapp.ui.telas.inicioTela

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.receitasapp.ui.telas.util.ReceitaViewModel


@Composable
fun TelaInicialNavHost(viewModel: ReceitaViewModel, drawerState: DrawerState) {
    val inicialNavController = rememberNavController()

    NavHost(
        navController = inicialNavController,
        startDestination = "TelaPrincipal"
    ) {
        composable("TelaPrincipal") {
            TelaPrincipal(viewModel, inicialNavController, drawerState)
        }
        composable("TelaAdicionar") {
            TelaAdicionar(viewModel, inicialNavController)
        }
        composable("buscarReceita/{receitaId}") { navRequest ->
            val receitaId = navRequest.arguments?.getString("receitaId")
            TelaVerReceitaInicio(receitaId?.toInt(), viewModel, inicialNavController)
        }
    }
}
