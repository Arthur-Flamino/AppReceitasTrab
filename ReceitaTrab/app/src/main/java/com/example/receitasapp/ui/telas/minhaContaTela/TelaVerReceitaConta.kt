package com.example.receitasapp.ui.telas.minhaContaTela

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.receitasapp.ui.telas.util.ReceitaViewModel
import com.example.receitasapp.ui.theme.TopCor

@Composable
fun TelaVerReceitaConta(
    receitaId: Int? = null,
    viewModel: ReceitaViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = { TopBar(navController) },
        content = { iPad -> ExibirReceita(receitaId, viewModel, iPad) }
    )

}

@Composable
private fun ExibirReceita(
    receitaId: Int?,
    viewModel: ReceitaViewModel,
    iPad: PaddingValues

) {
    LaunchedEffect(receitaId) {
        if (receitaId != null) {
            viewModel.buscarReceitaId(receitaId)
        }
    }

    val receita = viewModel.receita.value


    receita?.let {

        val favorito = remember { mutableStateOf(it.ehFavorito) }
        val feito = remember { mutableStateOf(it.ehFeito) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(iPad)
        ) {
            Text(
                text = it.titulo,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )

            if (!it.imagemUrl.isNullOrEmpty()) {
                AsyncImage(
                    model = it.imagemUrl,
                    contentDescription = "Imagem da receita ${it.titulo}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(bottom = 16.dp)
                )
            }

            Text(
                text = "Descrição: ${it.descricao}",
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Ingredientes: ${it.ingredientes}",
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Preparo: ${it.preparo}",
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = if (favorito.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorito",
                    tint = if (favorito.value) Color.Green else Color.Gray,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(23.dp)
                        .clickable { viewModel.atualizarFavorito(it) }
                )

                Icon(
                    imageVector = if (feito.value) Icons.Filled.Check else Icons.Filled.Check,
                    contentDescription = "Feito",
                    tint = if (feito.value) Color.Green else Color.Gray,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(23.dp)
                        .clickable { viewModel.atualizarFeito(it) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(navController: NavController) {

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }
            ) {

                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )

            }
        },
        title = { Text(text = "") },
        colors = TopAppBarDefaults.topAppBarColors(TopCor)
    )

}



