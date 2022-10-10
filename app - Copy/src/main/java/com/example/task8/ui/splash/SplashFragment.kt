package com.example.task8.ui.splash

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.task8.R
import com.example.task8.databinding.FragmentSplashBinding
import com.example.task8.ui.base.BaseFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SplashFragment : BaseFragmentBinding<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private val splashScreenViewModel: SplashViewModel by viewModels()



    override fun start() {
        viewLifecycleOwner.lifecycleScope.launch {
            splashScreenViewModel.splashFlow.collect {
                findNavController().navigate(R.id.logInFragment)

            }
        }

    }

}





