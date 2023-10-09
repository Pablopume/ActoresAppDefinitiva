package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository
import com.example.actoresapp.domain.modelo.Actores

class AddActorUseCase {
    fun addActor(actor: Actores) = Repository.addActor(actor)
    fun hayRepetidos(actor: Actores) = Repository.hayRepetidos(actor)
}