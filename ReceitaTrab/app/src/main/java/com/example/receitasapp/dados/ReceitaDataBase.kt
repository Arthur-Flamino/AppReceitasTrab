package com.example.receitasapp.dados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class ReceitaDataBase {

    @Database(entities = [Receita::class], version = 1)
    abstract class ReceitaDatabase : RoomDatabase() {

        abstract fun ReceitaDao(): ReceitaDao

        companion object{
            fun AbrirBancoDados(context: Context): ReceitaDatabase {
                return Room.databaseBuilder(
                    context.applicationContext,
                    ReceitaDatabase::class.java, "Receita.db"
                ).build()
            }
        }
    }
}