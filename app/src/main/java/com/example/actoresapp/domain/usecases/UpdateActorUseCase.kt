package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository
import com.example.actoresapp.domain.modelo.Actores

class UpdateActorUseCase {
    operator fun invoke (id :Int, actor: Actores)= Repository.updateActores(id,actor)
}