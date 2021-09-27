package com.example.primerparcial_aplicada2.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.primerparcial_aplicada2.Data.Db
import com.example.primerparcial_aplicada2.Repositorio.ProductosRepositorio
import kotlinx.coroutines.launch
import menu.Productos
import menu.ProductosDao
import java.lang.IllegalArgumentException

class ProductosVieeModel(application: Application) : ViewModel() {
    private val ProductosRepositorio = ProductosRepositorio(Db.getIntance(application))

    fun Insert(productos: Productos) = viewModelScope.launch {
        ProductosRepositorio.insert(productos)
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> Create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProductosVieeModel::class.java)) {
                @Suppress("UNCHED_CAST")
                return ProductosVieeModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")

        }
    }
}