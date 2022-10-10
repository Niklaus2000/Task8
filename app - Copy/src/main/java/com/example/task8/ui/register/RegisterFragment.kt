package com.example.task8.ui.register

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task8.databinding.FragmentRegisterBinding
import com.example.task8.ui.base.BaseFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class RegisterFragment : BaseFragmentBinding<FragmentRegisterBinding>(FragmentRegisterBinding::inflate){

    private val viewModel by viewModels<RegisterViewModel>()

    override fun start()  {
        viewInit()
        initCollectFlow()

    }


    private fun initCollectFlow() {
        collectFlow {
            viewModel.getSignUpEventFlow().collectLatest {
                if (it) {
                    findNavController().popBackStack()
                    Toast.makeText(requireContext(),"Success",Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(requireContext(),"Error",Toast.LENGTH_LONG).show()

                }
            }
        }
    }


    private fun viewInit() {
        binding.loginButton.setOnClickListener {
            viewModel.onSignUp(
                binding.emailEditTextView.text.toString(),
                binding.passwordEditTextView.text.toString(),
                binding.repeatPasswordEditTextView.toString()
            )
        }
    }
}