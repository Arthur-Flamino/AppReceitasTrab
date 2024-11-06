package com.example.receitasapp.ui.telas.util

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
//import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.receitasapp.ui.telas.minhaContaTela.MinhaContaRota

@Composable
fun BarraBotao(navController: NavController) {

    //val coroutineScope = rememberCoroutineScope()

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
                    tint = GetColorIcon(ehRotaFavorito),
                    modifier = Modifier.size(40.dp)
                )},
            label = { Text(text = "Favoritos", fontSize = 15.sp, color = getColorText(ehRotaFavorito)) }
            )

        NavigationBarItem(
            selected = ehRotaFeito,
            onClick = {
                navController.navigate(MinhaContaRota.TELA_FEITO_ROTA) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Feito",
                    tint = GetColorIcon(ehRotaFeito),
                    modifier = Modifier.size(40.dp)
                )},
            label = { Text(text = "Feitos", fontSize = 15.sp, color = getColorText(ehRotaFeito)) }
        )
    }
}

fun GetColorIcon(estaSelect: Boolean): Color {
    return if (estaSelect){
        Color.Black
    }else{
        Color.White
    }
}

fun getColorText(estaSelect: Boolean): Color {
    return if (estaSelect){
        Color.Black
    } else {
        Color.White
    }
}

