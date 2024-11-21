package com.example.receitasapp.ui.telas.inicioTela

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.receitasapp.dados.Receita
import com.example.receitasapp.ui.telas.util.ReceitaViewModel
import kotlinx.coroutines.launch

@Composable
fun TelaAdicionar(vModel: ReceitaViewModel, navController: NavController) {

    var coroutineScope = rememberCoroutineScope()

    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var ingredientes by remember { mutableStateOf("") }
    var preparo by remember { mutableStateOf("") }
    var imagemUrl by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.padding(
            top = 90.dp,
            start = 30.dp,
            end = 30.dp,
            bottom = 30.dp
        )
    ) {
        Text(
            text = "Nova Receita",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = titulo, onValueChange = { titulo = it })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = descricao, onValueChange = { descricao = it })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = ingredientes, onValueChange = { ingredientes = it })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = preparo, onValueChange = { preparo = it })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = imagemUrl, onValueChange = { imagemUrl = it })
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {
            coroutineScope.launch {
                val receitaNova = Receita(
                    titulo = titulo,
                    descricao = descricao,
                    ingredientes = ingredientes,
                    preparo = preparo,
                    imagemUrl = imagemUrl

                )
                vModel.gravarReceita(receitaNova)
                navController.popBackStack()
            }
        }) {
            Text(
                text = "Salvar Receita",
                fontSize = 28.sp
            )
        }


    }
}