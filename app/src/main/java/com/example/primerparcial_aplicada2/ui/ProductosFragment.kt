package com.example.primerparcial_aplicada2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.primerparcial_aplicada2.databinding.ActivityMainBinding
import java.util.zip.Inflater

class ProductosFragment : Fragment() {
    companion object{
        fun newInstance() = ProductosFragment()

    }
    private lateinit var vieeModel: ProductosVieeModel
    protected lateinit var binding: ProductosFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: viewGroup?,
        savedIntanceState: Bundle?
    ): View? {
        binding = ProductosFragmentBinding.inflate(inflater, container, false)
        return binButton.setOnClickListener{
            if (!Validar()){
                it.showMessage("Virificar que todo este bien para continuar")
            }else{
                vieeModel.Insert(LLenaclase)
                it.showMessage("Producto guardado")
                findNavController().navigateUp()
            }
        }
    }



}