package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository
import com.example.actoresapp.domain.modelo.Actores

class DeleteActorUseCase {
    fun deleteActor (actor: Actores) = Repository.deleteActor(actor)
    fun listEmpty() = Repository.listEmpty()
}