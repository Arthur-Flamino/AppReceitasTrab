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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.receitasapp.ui.telas.minhaContaTela.MinhaContaRota

@Composable
fun BarraBotao(navController: NavController) {
    NavigationBar(containerColor = Color(0xFFE33EDB)){
        NavigationBarItem(
            selected = true,
            onClick = {
                navController.navigate(MinhaContaRota.TELA_FAVORITO_ROTA) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorito",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )},
            label = { Text(text = "Favoritos") }
            )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(MinhaContaRota.TELA_FEITO_ROTA) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Feito",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )},
            label = { Text(text = "Feitos") }
        )
    }
}

