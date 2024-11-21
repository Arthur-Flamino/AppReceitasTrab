package com.example.receitasapp.dados

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class RemoteRepository() : IRepository {

    var db = FirebaseFirestore.getInstance()
    var receitaCollection = db.collection("receita")

    //coisa
    override fun listarTodasReceita(): Flow<List<Receita>> = callbackFlow {
        val listener = receitaCollection.addSnapshotListener { dados, erros ->
            if (erros != null) {
                close(erros)
                return@addSnapshotListener
            }
            if (dados != null) {
                val receitas = dados.documents.mapNotNull { dado ->
                    dado.toObject(Receita::class.java)
                }
                trySend(receitas)
            }
        }
        awaitClose { listener.remove() }
    }

    suspend fun getId(): Int {
        val dados = receitaCollection.get().await()
        //Recupera o maior id do firestore no format inteiro
        val maxId = dados.documents.mapNotNull {
            it.getLong("id")?.toInt()
        }.maxOrNull() ?: 0
        return maxId + 1
    }

    override suspend fun buscarReceitaId(idx: Int): Receita? {
        val dados = receitaCollection.document(idx.toString()).get().await()

        return dados.toObject(Receita::class.java)
    }


    override suspend fun gravarReceita(receita: Receita) {
        val document: DocumentReference

        receita.id = getId()
        document = receitaCollection.document(receita.id.toString())

        document.set(receita).await()

    }
}