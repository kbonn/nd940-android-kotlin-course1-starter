package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this
        binding.shoe = viewModel.emptyShoe()

        binding.cancel.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
        }

        viewModel.addingShoe.observe(viewLifecycleOwner, Observer { addingShoe ->
            if (addingShoe){
                findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
                viewModel.shoeAdded()
            }
        })

        return binding.root
    }
}