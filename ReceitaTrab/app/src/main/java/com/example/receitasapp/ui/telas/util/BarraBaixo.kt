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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BarraBotao(navController: NavController) {


    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route ?: "TelaFavoritos"

    val ehRotaFavorito = rotaAtual == "TelaFavoritos"
    val ehRotaFeito = rotaAtual == "TelaFeitos"

    NavigationBar(containerColor = Color(0xFFEC430E)) {
        NavigationBarItem(
            selected = ehRotaFavorito,
            onClick = {
                navController.navigate("TelaFavoritos")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorito",
                    tint = getColorIcon(ehRotaFavorito),
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(
                    text = "Favoritos",
                    fontSize = 15.sp,
                    color = getColorText(ehRotaFavorito)
                )
            }
        )

        NavigationBarItem(
            selected = ehRotaFeito,
            onClick = {
                navController.navigate("TelaFeitos")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Feito",
                    tint = getColorIcon(ehRotaFeito),
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Feitos", fontSize = 15.sp, color = getColorText(ehRotaFeito)) }
        )
    }
}

fun getColorIcon(estaSelect: Boolean): Color {
    return if (estaSelect) {
        Color.Black
    } else {
        Color.White
    }
}

fun getColorText(estaSelect: Boolean): Color {
    return if (estaSelect) {
        Color.Black
    } else {
        Color.White
    }
}

