package com.example.task8.ui.login

import androidx.navigation.fragment.findNavController
import com.example.task8.R
import com.example.task8.databinding.FragmentLogInBinding
import com.example.task8.ui.base.BaseFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment: BaseFragmentBinding<FragmentLogInBinding>(FragmentLogInBinding::inflate) {


    override fun start() {
        binding.loginButton.setOnClickListener {
//           findNavController().navigate(R.id.registerFragment)
        }
        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
    }
}