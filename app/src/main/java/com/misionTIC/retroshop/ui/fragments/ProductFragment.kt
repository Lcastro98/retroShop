package com.misionTIC.retroshop.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.misionTIC.retroshop.OnProductListener
import com.misionTIC.retroshop.databinding.FragmentProductBinding
import com.misionTIC.retroshop.ui.adapters.Product
import com.misionTIC.retroshop.ui.adapters.ProductAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        productAdapter = ProductAdapter(
            listOf(
                Product("1","Product 1","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("2","Product 2","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("3","Product 3","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("4","Product 4","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("5","Product 5","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("6","Product 6","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("7","Product 7","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("8","Product 8","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("9","Product 9","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("10","Product 10","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000")
            )
        )
        productAdapter.listener = object: OnProductListener {
            override fun onClick(item: Product) {
                Log.d("Product", item.name)
            }
        }
        productManager = GridLayoutManager(requireContext(),2)
        binding.productRecycler.apply {
            adapter = productAdapter
            layoutManager = productManager
        }
    }

}