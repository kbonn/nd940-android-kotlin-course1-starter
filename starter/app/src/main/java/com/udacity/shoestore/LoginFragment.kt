package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        binding.createLoginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.loginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        return binding.root
    }
}