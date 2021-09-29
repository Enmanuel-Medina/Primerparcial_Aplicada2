package com.example.primerparcial_aplicada2.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Productos(
    @PrimaryKey(autoGenerate = true)
    var ProductoId: Long,
    var Descripcion: String,
    var Existencia: Float,
    var Costo: Float,
    var ValorInventario: Float
)