package com.example.receitasapp.ui.telas.inicioTela

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.receitasapp.ui.telas.util.ReceitaViewModel

@Composable
fun TelaVerReceita(
    receitaId: Int? = null,
    viewModel: ReceitaViewModel,
    navController: NavController
){
    LaunchedEffect(receitaId) {
        if (receitaId != null) {
            viewModel.buscarReceitaId(receitaId)
        }
    }

    val receita = viewModel.receita.value

    IconButton(
        onClick = { navController.popBackStack() },
        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Voltar",
            tint = Color.Black
        )
    }

    receita?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = it.titulo,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Descrição: ${it.descricao}",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Ingredientes: ${it.ingredientes}",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Preparo: ${it.preparo}",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = if (it.ehFavorito) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorito",
                    tint = if (it.ehFavorito) Color.Green else Color.Gray,
                    modifier = Modifier.padding(end = 4.dp)
                )

                Icon(
                    imageVector = if (it.ehFeito) Icons.Filled.Check else Icons.Filled.Check,
                    contentDescription = "Feito",
                    tint = if (it.ehFeito) Color.Green else Color.Gray,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
        }
    }
}



