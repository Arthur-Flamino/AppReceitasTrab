package com.example.receitasapp.ui.telas.minhaContaTela

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.receitasapp.ui.telas.util.BarraBotao
import com.example.receitasapp.ui.telas.util.BarraTop
import com.example.receitasapp.ui.telas.util.ReceitaViewModel

@Composable
fun TelaFeito(viewModel: ReceitaViewModel, drawerState: DrawerState, navController: NavController){

    Scaffold(
        topBar = { BarraTop(drawerState) },
        content = { iPad -> TextoPrincipal(viewModel, iPad, navController) },
        bottomBar = { BarraBotao(navController) }
    )
}

@Composable
private fun TextoPrincipal(viewModel: ReceitaViewModel, iPad: PaddingValues, navController: NavController) {

    val receitas by viewModel.todasReceitas.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(iPad),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        val receitasFavoritas = receitas.filter { it.ehFeito }


        for (receita in receitasFavoritas) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("buscarReceita/${receita.id}")
                    }
                    .fillMaxWidth()
            ) {
                Text(
                    text = receita.titulo,
                    fontSize = 26.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}