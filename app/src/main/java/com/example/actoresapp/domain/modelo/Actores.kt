package com.example.actoresapp.domain.modelo

data class Actores(val nombre: String="",val vivo: Boolean=true ,val peliculaFamosa:String="", val premiosOscar:Int=0, val genero: String="") {
    override fun toString(): String {
        return "Actores(nombre='$nombre', vivo='$vivo', peliculaFamosa='$peliculaFamosa', premiosOscar=$premiosOscar, genero='$genero')"
    }

}