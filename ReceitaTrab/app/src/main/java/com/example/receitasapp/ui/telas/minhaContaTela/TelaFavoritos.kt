package com.example.receitasapp.ui.telas.minhaContaTela

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.receitasapp.ui.telas.util.BarraBotao
import com.example.receitasapp.ui.telas.util.BarraTop

@Composable
fun TelaFavorito(drawerState: DrawerState, navC: NavController){

    Scaffold(
        topBar = { BarraTop(drawerState) },
        content = { iPad -> TextoPrincipal(iPad) },
        bottomBar = { BarraBotao(navC) }
    )
}

@Composable
private fun TextoPrincipal(iPad: PaddingValues) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Favorito",
            Modifier.padding(iPad),
            fontSize = 40.sp
        )
    }
}