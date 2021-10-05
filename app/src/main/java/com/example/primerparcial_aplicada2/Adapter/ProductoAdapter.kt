package com.example.primerparcial_aplicada2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_aplicada2.Model.Productos
import com.example.primerparcial_aplicada2.databinding.ProductoRowBinding


class ProductoAdapter : RecyclerView.Adapter<ProductoAdapter.ProductosViewHolder>() {
    private var ProductosList = emptyList<Productos>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val binding = ProductoRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        holder.bind(ProductosList[position])
    }

    override fun getItemCount(): Int {
        return ProductosList.size
    }

    fun submitList(list: List<Productos>)
    {
        ProductosList = list
        notifyDataSetChanged()
    }

    inner class ProductosViewHolder(private val binding: ProductoRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Productos) {
            binding.productoIdTextView.text = item.ProductoId.toString()
            binding.descripcionTextView.text = item.Descripcion
            binding.existenciaTextView.text = item.Existencia.toString()
            binding.costoTextView.text = item.Costo.toString()
            binding.valorInventarioTextView.text = item.ValorInventario.toString()
        }
    }

}
