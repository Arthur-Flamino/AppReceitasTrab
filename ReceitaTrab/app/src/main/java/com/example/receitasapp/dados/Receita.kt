package com.example.receitasapp.dados

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Receita(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val titulo: String,
    val descricao: String,
    val ingredientes: String,
    val preparo: String,
    val imagemUrl: String? = null,
    var ehFavorito: Boolean = false,
    var ehFeito: Boolean = false
) {

    constructor(): this(
        null, "", "", "", "", null, false, false
    )
}