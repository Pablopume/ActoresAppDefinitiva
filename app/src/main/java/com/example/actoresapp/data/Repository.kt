package com.example.actoresapp.data

import com.example.actoresapp.domain.modelo.Actores

object Repository {
    private val actores = mutableListOf<Actores>()


    init {
        actores.add(Actores("Brad", true, "El Titanic", 2, "Masculino"))
        actores.add(Actores("Santiago", true, "Torrente", 9,"Femenino"))
        actores.add(Actores("Antonio", true, "El zorro", 7,"Masculino"))
        actores.add(Actores("Leonardo", true, "Shutter Island", 1,"Masculino"))
    }

    fun addActor(actor: Actores) = actores.add(actor)

    fun deleteActor(actor: Actores)= actores.remove(actor)
    fun getActores(): List<Actores> = actores

    fun deshabilitarIzquierda(actor: Actores): Boolean{
        return actores.indexOf(actor)==0
    }

    fun deshabilitarDerecha(actor: Actores): Boolean{
        return actores.indexOf(actor)+1==actores.size
    }
    fun deleteActores(id: Int) = actores.remove(actores[id])

    fun getActorAnterior(actor: Actores): Actores {

        val actor2 : Actores = if ((actores.indexOf(actor)-1>=0))
            actores[actores.indexOf(actor)-1]
        else{
            actor
        }
        return actor2
    }

    fun getActorSiguiente(actor: Actores): Actores{
        val actor2 : Actores = if ((actores.indexOf(actor)+1<=actores.size-1))
            actores[actores.indexOf(actor)+1]
        else{
            actor
        }
        return actor2
    }
    fun updateActores(actorAntiguo: Actores, actorActualizado: Actores) {
        actores[actores.indexOf(actorAntiguo)] = actorActualizado
    }
    fun hayRepetidos(actor: Actores): Boolean {
        return actores.contains(actor)
    }
    fun getActorId(id: Int): Actores {
        return actores[id]
    }

    fun listEmpty(): Boolean{
        return actores.isEmpty()
    }
}