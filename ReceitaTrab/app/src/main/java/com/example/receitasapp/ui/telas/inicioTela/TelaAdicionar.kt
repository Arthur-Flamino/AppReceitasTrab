package com.example.receitasapp.ui.telas.inicioTela

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
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
import androidx.room.util.TableInfo
import com.example.receitasapp.ui.telas.util.ReceitaViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun TelaAdicionar(vModel: ReceitaViewModel, navController: NavController){

    var coroutineScope = rememberCoroutineScope()

    var titulo by remember { mutableStateOf( "") }
    var descricao by remember { mutableStateOf("") }
    var ingredientes by remember { mutableStateOf("") }
    var preparo by remember { mutableStateOf("") }


    Column(
    modifier = Modifier.padding(
        top =  90.dp,
        start = 30.dp,
        end = 30.dp,
        bottom = 30.dp
    )
    ) {
        Text(text = "Nova Receita",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
            )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = titulo, onValueChange =)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = descricao, onValueChange =)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = ingredientes, onValueChange =)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = preparo, onValueChange =)
        Spacer(modifier = Modifier.height(17.dp))
        Button(onClick = { /*TODO*/ }) {
            
        }
    }
}