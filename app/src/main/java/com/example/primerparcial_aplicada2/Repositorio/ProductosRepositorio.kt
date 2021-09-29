package com.example.primerparcial_aplicada2.Repositorio

import com.example.primerparcial_aplicada2.Data.ProductoDb
import com.example.primerparcial_aplicada2.Model.Productos

class ProductosRepositorio(private val database: ProductoDb ) {
    suspend fun Insert(producto: Productos){
        database.productoDao.Insert(producto)
    }

    suspend fun Delete(producto: Productos){
        database.productoDao.Delete(producto)
    }

    suspend fun Update(producto: Productos){
        database.productoDao.Update(producto)
    }

    suspend fun Find(ProductoId: Long){
        database.productoDao.Find(ProductoId)
    }
}