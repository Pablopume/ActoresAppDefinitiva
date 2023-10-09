package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository
import com.example.actoresapp.domain.modelo.Actores

class GetActoresUseCase {
    fun invoke() = Repository.getActores()
    fun obtenerActorSiguiente(actor: Actores) = Repository.getActorSiguiente(actor)
    fun obtenerActorAnterior(actor: Actores) = Repository.getActorAnterior(actor)
}