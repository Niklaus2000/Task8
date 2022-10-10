package com.example.task8.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch


class SplashViewModel : ViewModel() {

    private val _splashFlow = MutableSharedFlow<Boolean>()
    val splashFlow: MutableSharedFlow<Boolean> get() = _splashFlow



    init {
        viewModelScope.launch {
            delay(5000)
            _splashFlow.emit(true)
        }
    }

}