package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository
import com.example.actoresapp.domain.modelo.Actores

class AddActorUseCase {
    operator fun invoke (actor : Actores) = Repository.addActor(actor)
}