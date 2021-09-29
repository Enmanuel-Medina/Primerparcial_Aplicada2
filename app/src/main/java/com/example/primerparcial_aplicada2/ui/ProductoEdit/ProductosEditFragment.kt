package com.example.primerparcial_aplicada2.ui.ProductoEdit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.primerparcial_aplicada2.Extensore.getFloat
import com.example.primerparcial_aplicada2.Extensore.showMessage
import com.example.primerparcial_aplicada2.Model.Productos
import com.example.primerparcial_aplicada2.databinding.ProductosEditFragmentBinding

class ProductosEditFragment : Fragment() {

    companion object {
        fun newInstance() = ProductosEditFragment()
    }

    private lateinit var viewModel: ProductoEditViewModel
    private lateinit var binding: ProductosEditFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ProductosEditFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProvider(this, ProductoEditViewModel.Factory(requireActivity().application))
                .get(ProductoEditViewModel::class.java)

        binding.guardarButton.setOnClickListener {
            if (!Validar())
                it.showMessage("Verifique los errores para continuar")
            else {
                if (binding.productoIdTextInputEditText.text?.isNotEmpty() == true) {
                    if (viewModel.Find(AtrapaId()) != null) {
                        viewModel.Update(LlenaUpdate())
                        it.showMessage("Producto actualizado")
                    }
                } else {
                    viewModel.Insert(LlenaClase())
                    it.showMessage("Producto guardado")
                }

            }
        }

        binding.nuevoButton.setOnClickListener {

        }

        binding.eliminarButton.setOnClickListener {
            viewModel.Delete(AtrapaId())
            it.showMessage("Producto eliminado")

        }

    }






    fun LlenaClase(): Productos {
        return Productos(
            0,
            binding.descripcionTextInputEditText.text.toString(),
            binding.existenciaTextInputEditText.text.getFloat(),
            binding.costoTextInputEditText.text.getFloat(),
            binding.valorInventarioTextInputEditText.text.getFloat()
        )
    }

    fun AtrapaId(): Productos {
        return Productos(
            binding.productoIdTextInputEditText.text.toString().toLong(),
            "",
            0f,
            0f,
            0f
        )
    }

    fun LlenaUpdate(): Productos {
        return Productos(
            binding.productoIdTextInputEditText.text.toString().toLong(),
            binding.descripcionTextInputEditText.text.toString(),
            binding.existenciaTextInputEditText.text.getFloat(),
            binding.costoTextInputEditText.text.getFloat(),
            binding.valorInventarioTextInputEditText.text.getFloat()
        )
    }


    fun Validar(): Boolean {
        var esValido = true

        binding.existenciaTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir una cantidad válida del producto"
                esValido = false
            } else
                it.error = null
        }

        binding.costoTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir una costo válido"
                esValido = false
            } else
                it.error = null
        }

        binding.valorInventarioTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir una valor válido"
                esValido = false
            } else
                it.error = null
        }

        binding.descripcionTextInputEditText.let {
            if (it.text.isNullOrEmpty()) {
                it.error = "Debe introducir una descripción valida"
                esValido = false
            } else
                it.error = null
        }

        return esValido
    }
}
