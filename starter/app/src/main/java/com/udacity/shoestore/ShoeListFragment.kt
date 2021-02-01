package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.setMargins
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        val shoeListLayout = binding.root.findViewById<LinearLayout>(R.id.shoeListLayout)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->
                val shoeItemBinding = DataBindingUtil.inflate<ShoeItemBinding>(inflater, R.layout.shoe_item, container, false)
                shoeItemBinding.shoe = shoe
                shoeListLayout.addView(shoeItemBinding.root)
            }
        })

        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeList_to_shoeDetailFragment)
        }
        return binding.root
    }
}