package com.example.actoresapp.domain.modelo

class Actores(val nombre: String,val vivo: Boolean ,val peliculaFamosa:String, val premiosOscar:Int, val genero: String) {
    override fun toString(): String {
        return "Actores(nombre='$nombre', vivo='$vivo', peliculaFamosa='$peliculaFamosa', premiosOscar=$premiosOscar, genero='$genero')"
    }
}