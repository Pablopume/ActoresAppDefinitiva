package com.example.actoresapp.ui.pantallamain

import com.example.actoresapp.domain.modelo.Actores

data class MainState(
    val actores: Actores = Actores("", true, "", 0, ""),
    val error: String? = null,
    val botonIzquierda: Boolean? = true,
    val botonDerecha: Boolean? = true
)
