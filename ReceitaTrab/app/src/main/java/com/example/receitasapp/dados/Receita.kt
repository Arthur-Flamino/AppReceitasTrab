package com.example.receitasapp.dados

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Receita(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val titulo: String,
    val descricao: String,
    val ingredientes: String,
    val preparo: String,
    val ehFavorito: Boolean = false,
    val ehFeito: Boolean = false
) {
    constructor(): this(null, "", "", "", "", false, false)
}