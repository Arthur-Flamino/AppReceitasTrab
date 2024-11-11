package com.example.receitasapp.ui.telas.inicioTela

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.receitasapp.dados.Receita
import com.example.receitasapp.dados.ReceitaDao
import com.example.receitasapp.dados.ReceitaDataBase
import com.example.receitasapp.ui.telas.util.BarraTop
import kotlinx.coroutines.launch


@Composable
fun TelaInicial(drawerState: DrawerState){

    Scaffold(
        topBar = { BarraTop(drawerState) },
        content = { iPad -> TextoPrincipal(iPad) },

    )
}

//@Composable
//fun ListarTeste(){
//
//    val context = LocalContext.current
//    val  db =
//
//    var receitas by remember { mutableStateOf(listOf<Receita>()) }
//
//    var coroutineScope = rememberCoroutineScope()
//
//    LaunchedEffect(Unit) {
//        coroutineScope.launch {
//            if()
//        }
//    }
//}


@Composable
private fun TextoPrincipal(iPad: PaddingValues) {

    val textos = listOf("Bolo", "Pudim", "Suflê")

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(iPad),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        for (texto in textos){
            Text(text = texto,
                modifier = Modifier.padding(16.dp),
                fontSize = 26.sp
            )
        }
    }

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Inicial",
//            Modifier.padding(iPad),
//            fontSize = 40.sp
//        )
//    }
}