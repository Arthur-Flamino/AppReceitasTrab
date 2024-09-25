package com.example.receitasapp.ui.telas.minhaContaTela

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object MinhaContaRota{
    val TELA_FAVORITO_ROTA = "TelaFavoritos"
    val TELA_FEITO_ROTA = "TelaFeitos"
}

@Composable
fun MinhaConta(drawerState: DrawerState){

    val contaBaixoNav = rememberNavController()

    NavHost(
        navController = contaBaixoNav,
        startDestination = MinhaContaRota.TELA_FAVORITO_ROTA
    ){
        composable(MinhaContaRota.TELA_FAVORITO_ROTA) {
            TelaFavorito(drawerState, contaBaixoNav)
        }
        composable(MinhaContaRota.TELA_FEITO_ROTA) {
            TelaFeito(drawerState, contaBaixoNav)
        }
    }

}