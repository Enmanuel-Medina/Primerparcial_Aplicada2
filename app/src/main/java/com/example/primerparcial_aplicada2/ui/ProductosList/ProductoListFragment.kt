package com.example.primerparcial_aplicada2.ui.ProductosList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.primerparcial_aplicada2.Adapter.ProductoAdapter
import com.example.primerparcial_aplicada2.R
import com.example.primerparcial_aplicada2.databinding.ProductoListFragmentBinding

class ProductoListFragment : Fragment() {

    companion object {
        fun newInstance() = ProductoListFragment()
    }

    private var _binding: ProductoListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ProductoListFragmentBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, ProductoListViewModel.Factory(requireActivity().application))
                .get(ProductoListViewModel::class.java)

        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listaRecyclerVieW.adapter = ProductoAdapter()
        val adapter = binding.listaRecyclerView.adapter as ProductoAdapter

        viewModel.list.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })
    }
*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
