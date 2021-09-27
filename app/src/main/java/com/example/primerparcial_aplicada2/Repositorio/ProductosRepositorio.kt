package com.example.primerparcial_aplicada2.Repositorio

import com.example.primerparcial_aplicada2.Data.Db
import menu.Productos

class ProductosRepositorio(private val database: Db) {
    suspend fun insert(productos: Productos){

         database.productosDao.Insert(productos)

    }
}