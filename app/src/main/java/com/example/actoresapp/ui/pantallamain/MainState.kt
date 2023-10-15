package com.example.actoresapp.ui.pantallamain

import com.example.actoresapp.domain.modelo.Actores

data class MainState(
    val actores: Actores = Actores(Constantes.EMPTY, true,Constantes.EMPTY, 0,Constantes.EMPTY),
    val error: String? = null,
    val botonIzquierda: Boolean? = true,
    val botonDerecha: Boolean? = true
)
