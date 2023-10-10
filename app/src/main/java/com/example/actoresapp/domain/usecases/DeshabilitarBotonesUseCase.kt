package com.example.actoresapp.domain.usecases

import com.example.actoresapp.data.Repository
import com.example.actoresapp.domain.modelo.Actores

class DeshabilitarBotonesUseCase {
    fun deshabilitarIzquierda(actor: Actores) = Repository.deshabilitarIzquierda(actor)
    fun deshabilitarDerecha(actor: Actores) = Repository.deshabilitarDerecha(actor)
}