package com.example.primerparcial_aplicada2.ui.ProductosList

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.primerparcial_aplicada2.Data.ProductoDb
import com.example.primerparcial_aplicada2.Model.Productos
import com.example.primerparcial_aplicada2.Repositorio.ProductosRepositorio
import com.example.primerparcial_aplicada2.ui.ProductoEdit.ProductoEditViewModel
import java.lang.IllegalArgumentException

class ProductoListViewModel : ViewModel() {
   // private val productoRepository = ProductosRepositorio(ProductoDb.getInstance(application))
  //  val list = productoRepository.Lista()


    //Factory

    class Factory (val app: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProductoEditViewModel::class.java)){
                @Suppress("UNCHECKER_CAST")
                return ProductoEditViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewModel")
        }
    }
}
