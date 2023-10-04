package com.example.actoresapp.data

import com.example.actoresapp.domain.modelo.Actores

object Repository {
    private val actores = mutableListOf<Actores>()


    init {
        actores.add(Actores("Brad", true, "El Titanic", 2, "Masculino"))
        actores.add(Actores("Santiago", true, "Torrente", 33,"Masculino"))
        actores.add(Actores("Antonio", true, "El zorro", 7,"Masculino"))
        actores.add(Actores("Leonardo", true, "Shutter Island", 1,"Masculino"))
    }

    fun addActor(actor: Actores) = actores.add(actor)


    fun getActores(): List<Actores> = actores


    fun deleteActores(id: Int) = actores.remove(actores[id])


    fun updateActores(id: Int, actor: Actores) {
        actores[id] = actor
    }
}