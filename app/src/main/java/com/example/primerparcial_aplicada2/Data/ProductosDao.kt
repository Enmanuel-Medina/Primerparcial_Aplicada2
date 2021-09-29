package com.example.primerparcial_aplicada2.Data

import androidx.room.*
import com.example.primerparcial_aplicada2.Model.Productos


@Dao
interface ProductoDao {

    @Insert
    suspend fun Insert(productos: Productos)

    @Update
    suspend fun Update(productos: Productos)

    @Delete
    suspend fun Delete(productos:Productos)

    @Query("select * from Productos where ProductoId = :key")
    suspend fun Find(key:Long) : Productos?
}