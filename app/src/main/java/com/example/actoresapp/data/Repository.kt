package com.example.actoresapp.data

import com.example.actoresapp.domain.modelo.Actores
import com.example.actoresapp.ui.pantallamain.Constantes
object Repository {
    private val actores = mutableListOf<Actores>()

    init {
        actores.add(Actores(Constantes.brad, true, Constantes.titanic, 2, Constantes.masc))
        actores.add(Actores(Constantes.santi, true, Constantes.torrente, 9, Constantes.masc))
        actores.add(Actores(Constantes.PENÉLOPE, true, Constantes.PIRATAS_DEL_CARIBE, 2, Constantes.fem))
        actores.add(Actores(Constantes.antonio, true, Constantes.zorro, 7, Constantes.masc))
        actores.add(Actores(Constantes.leonardo, true, Constantes.shutter, 1, Constantes.masc))
    }

    fun addActor(actor: Actores) = actores.add(actor)

    fun deleteActor(actor: Actores) = actores.remove(actor)

    fun getActores(): List<Actores> = actores

    fun deshabilitarIzquierda(actor: Actores): Boolean {
        return actores.indexOf(actor) == 0
    }

    fun deshabilitarDerecha(actor: Actores): Boolean {
        return actores.indexOf(actor) + 1 == actores.size
    }

    fun getActorAnterior(actor: Actores): Actores {

        val actor2: Actores = if ((actores.indexOf(actor) - 1 >= 0))
            actores[actores.indexOf(actor) - 1]
        else {
            actor
        }
        return actor2
    }

    fun getActorSiguiente(actor: Actores): Actores {
        val actor2: Actores = if ((actores.indexOf(actor) + 1 <= actores.size - 1))
            actores[actores.indexOf(actor) + 1]
        else {
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

    fun listEmpty(): Boolean {
        return actores.isEmpty()
    }
}