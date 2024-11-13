package com.example.receitasapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.receitasapp.ui.telas.inicioTela.TelaInicialNavHost
import com.example.receitasapp.ui.telas.inicioTela.TelaPrincipal
import com.example.receitasapp.ui.telas.minhaContaTela.MinhaContaNavHost
import com.example.receitasapp.ui.telas.util.ReceitaViewModel
import kotlinx.coroutines.launch


@Composable
fun ReceitaController(viewModel: ReceitaViewModel){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerConteudo(navController, drawerState) },
        content ={
            NavHost(
                navController = navController,
                startDestination = "tela1")
            {
                composable("tela1") {
                    TelaInicialNavHost(viewModel, drawerState)
                }
                composable("tela2") {
                    MinhaContaNavHost(drawerState)
                }
            }
        }
    )

}

@Composable
private fun DrawerConteudo(
    navController: NavController,
    drawerState: DrawerState
){
    val coroutineScope = rememberCoroutineScope()

    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route?: "tela1"

    val ehRota1 = rotaAtual == "tela1"
    val ehRota2 = rotaAtual == "tela2"

    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color(0xFFF05D2F))
            .padding(31.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        TextButton(
            colors = ButtonDefaults.buttonColors(containerColor = getColorMenu(ehRota1)),
            onClick ={
                navController.navigate("tela1")
                coroutineScope.launch { drawerState.close() }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Rota 1",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRota1)
            )
            Text(text = "Inicio", fontSize = 30.sp, color = getColorTexto(ehRota1))
        }
        TextButton(
            colors = ButtonDefaults.buttonColors(containerColor = getColorMenu(ehRota2)),
            onClick ={
                navController.navigate("tela2")
                coroutineScope.launch { drawerState.close() }
            }
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Rota 2",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRota2)
            )
            Text(text = "Conta", fontSize = 30.sp, color = getColorTexto(ehRota2))
        }
    }
}

fun getColorTexto(estaSelecionada: Boolean): Color {
    return if (estaSelecionada){
        Color.DarkGray
    } else {
        Color.Black
    }
}

fun getColorMenu(estaSelecionada: Boolean): Color {
    return if (estaSelecionada){
        Color.White
    } else {
        Color.Transparent
    }
}
