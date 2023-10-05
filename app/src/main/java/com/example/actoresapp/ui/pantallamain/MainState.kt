package com.example.actoresapp.ui.pantallamain

import com.example.actoresapp.domain.modelo.Actores

data class MainState(
val actores: Actores= Actores("Fernando",true,"Desembarque",2,"Masculino"))
val error: String?= ""

