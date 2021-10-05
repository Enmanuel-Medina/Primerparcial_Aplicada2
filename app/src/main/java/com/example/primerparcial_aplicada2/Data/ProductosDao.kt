package com.example.primerparcial_aplicada2.Data

import androidx.lifecycle.LiveData
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

    @Query("select * from Productos order by ProductoId asc")
    fun Lista() : LiveData<List<Productos>>
}