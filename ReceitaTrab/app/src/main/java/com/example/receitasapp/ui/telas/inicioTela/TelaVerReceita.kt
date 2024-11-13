package com.example.receitasapp.ui.telas.inicioTela

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.receitasapp.ui.telas.util.ReceitaViewModel
import java.lang.reflect.Modifier

@Composable
fun TelaVerReceita(
    receitaId: Int? = null,
    viewModel: ReceitaViewModel,
    navController: NavController
){
    // Carrega a receita usando LaunchedEffect
    LaunchedEffect(receitaId) {
        if (receitaId != null) {
            viewModel.buscarReceitaId(receitaId)
        }
    }

    // Observe o estado da receita através do mutableState na ViewModel
    val receita = viewModel.receita.value

    // Exibe as informações da receita
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
                modifier = Modifier.padding(bottom = 8.dp)
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
                Text(
                    text = if (it.ehFavorito) "Favorito" else "Não Favorito",
                    fontSize = 18.sp,
                    color = if (it.ehFavorito) Color.Green else Color.Gray
                )

                Text(
                    text = if (it.ehFeito) "Feito" else "Não Feito",
                    fontSize = 18.sp,
                    color = if (it.ehFeito) Color.Green else Color.Gray
                )
            }
        }
    }
}



