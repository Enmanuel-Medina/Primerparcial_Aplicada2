package com.example.primerparcial_aplicada2.ui.ProductoEdit

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.primerparcial_aplicada2.Data.ProductoDb
import com.example.primerparcial_aplicada2.Model.Productos
import com.example.primerparcial_aplicada2.Repositorio.ProductosRepositorio
import com.example.primerparcial_aplicada2.databinding.ProductosEditFragmentBinding
import kotlinx.coroutines.launch

class ProductoEditViewModel (application: Application) : ViewModel() {

    private lateinit var binding: ProductosEditFragmentBinding
    private val productoRepository = ProductosRepositorio(ProductoDb.getInstance(application))

    fun Insert(producto: Productos) = viewModelScope.launch {
        productoRepository.Insert(producto)
    }

    fun Delete(producto: Productos) = viewModelScope.launch {
        productoRepository.Delete(producto)
    }

    fun Update(producto: Productos) = viewModelScope.launch {
        productoRepository.Update(producto)
    }

    fun Find(producto: Productos) = viewModelScope.launch {
        productoRepository.Find(producto.ProductoId)
    }


    //Factory
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom((ProductoEditViewModel::class.java))) {
                @Suppress("UNCHECKED_CAST")
                return ProductoEditViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewModel")
        }
    }
}
