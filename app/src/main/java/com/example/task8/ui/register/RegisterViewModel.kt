package com.example.task8.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.data.model.User
import com.example.task8.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    val signUpEventFlow = MutableSharedFlow<Boolean>()
    fun getSignUpEventFlow(): SharedFlow<Boolean> {
        return signUpEventFlow
    }

    //    fun onSignUp(email: String, password: String,repeatPassword: String)  {
//        userRepository.createUser(User(email,password,repeatPassword)) {  Result ->
//            viewModelScope.launch {
//                signUpEventFlow.emit(Result == Result)
//            }
//        }
//
//    }
    fun onSignUp(email: String , password: String , repeatPassword: String) {
        userRepository.createUser(User(email , password , repeatPassword)) { result ->
            viewModelScope.launch {
                signUpEventFlow.emit(result)
            }
        }

    }

}


