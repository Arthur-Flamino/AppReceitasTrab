package com.example.receitasapp.ui.telas.inicioTela

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.receitasapp.ui.telas.util.BarraTop
import com.example.receitasapp.ui.telas.util.ReceitaViewModel


@Composable
fun TelaPrincipal(
    vModel: ReceitaViewModel,
    navController: NavController,
    drawerState: DrawerState
) {

    Scaffold(
        topBar = { BarraTop(drawerState) },
        content = { iPad -> TextoPrincipal(vModel, navController, iPad) },
        bottomBar = { Adicionar(navController) }
    )
}


@Composable
private fun TextoPrincipal(
    vModel: ReceitaViewModel,
    navController: NavController,
    iPad: PaddingValues
) {


    val receitas by vModel.todasReceitas.collectAsState()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(iPad),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        for (receita in receitas) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("buscarReceita/${receita.id}")
                    }
                    .fillMaxWidth()
            ) {

                if (receita.imagemUrl != null) {
                    AsyncImage(
                        model = receita.imagemUrl,
                        contentDescription = "Imagem da receita ${receita.titulo}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }

                Text(
                    text = receita.titulo,
                    fontSize = 26.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun Adicionar(navController: NavController) {
    IconButton(
        onClick = {
            navController.navigate("TelaAdicionar")
        },
        modifier = Modifier.Companion
            .padding(22.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Adicionar Receita",
            tint = Color.Green
        )
    }
}


