package com.example.receitasapp.ui.telas.minhaContaTela

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun MinhaContaNavHost(drawerState: DrawerState){

    val contaNavController = rememberNavController()

    NavHost(
        navController = contaNavController,
        startDestination = "TelaFavoritos"
    ){
        composable("TelaFavoritos") {
            TelaFavorito(drawerState, contaNavController)
        }
        composable("TelaFeitos") {
            TelaFeito(drawerState, contaNavController)
        }
    }

}