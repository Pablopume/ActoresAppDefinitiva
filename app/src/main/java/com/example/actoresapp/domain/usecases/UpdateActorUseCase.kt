package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository
import com.example.actoresapp.domain.modelo.Actores

class UpdateActorUseCase {
    operator fun invoke(actorAntiguo: Actores, actorActualizado: Actores) =
        Repository.updateActores(actorAntiguo, actorActualizado)
}