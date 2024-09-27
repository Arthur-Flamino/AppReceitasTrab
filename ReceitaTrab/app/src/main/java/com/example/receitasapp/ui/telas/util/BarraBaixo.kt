package com.example.receitasapp.ui.telas.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.receitasapp.ReceitaRotas
import com.example.receitasapp.ui.telas.minhaContaTela.MinhaContaRota
import kotlin.contracts.Returns

@Composable
fun BarraBotao(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()

    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route?: MinhaContaRota.TELA_FAVORITO_ROTA

    val ehRotaFavorito = rotaAtual == MinhaContaRota.TELA_FAVORITO_ROTA
    val ehRotaFeito = rotaAtual == MinhaContaRota.TELA_FEITO_ROTA

    NavigationBar(containerColor = Color(0xFFE33EDB)){
        NavigationBarItem(
            selected = ehRotaFavorito,
            onClick = {
                navController.navigate(MinhaContaRota.TELA_FAVORITO_ROTA) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorito",
                    tint = GetColorMenu(ehRotaFavorito),
                    modifier = Modifier.size(40.dp)
                )},
            label = { Text(text = "Favoritos") }
            )

        NavigationBarItem(
            selected = ehRotaFeito,
            onClick = {
                navController.navigate(MinhaContaRota.TELA_FEITO_ROTA) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Feito",
                    tint = GetColorMenu(ehRotaFeito),
                    modifier = Modifier.size(40.dp)
                )},
            label = { Text(text = "Feitos") }
        )
    }
}

fun GetColorMenu(ehRotaFavorito: Boolean): Color {
    return if (ehRotaFavorito){
        Color.Black
    }else{
        Color.White
    }
}

