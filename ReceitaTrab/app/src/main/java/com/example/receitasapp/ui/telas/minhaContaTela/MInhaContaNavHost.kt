package com.example.receitasapp.ui.telas.minhaContaTela

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.receitasapp.ui.telas.util.ReceitaViewModel


@Composable
fun MinhaContaNavHost(viewModel: ReceitaViewModel, drawerState: DrawerState) {

    val contaNavController = rememberNavController()

    NavHost(
        navController = contaNavController,
        startDestination = "TelaFavoritos"
    ) {
        composable("TelaFavoritos") {
            TelaFavorito(viewModel, drawerState, contaNavController)
        }
        composable("TelaFeitos") {
            TelaFeito(viewModel, drawerState, contaNavController)
        }
        composable("buscarReceita/{receitaId}") { navRequest ->
            val receitaId = navRequest.arguments?.getString("receitaId")
            TelaVerReceitaConta(receitaId?.toInt(), viewModel, contaNavController)
        }
    }

}