package com.example.task8.data.repository

import com.example.task8.data.model.User
import com.example.task8.data.response.Result

interface UserRepository {
//    fun createUser(user: User, onResult:(Result) -> Unit)
//    fun logIn(user: User, onResult:(Result) -> Unit)
//    fun logOut(user: User, onResult:(Result) -> Unit)


    fun createUser(user: User, onResult: (Boolean) -> Unit)
    fun logIn(user: User, onResult: (Boolean) -> Unit)
    fun logOut(user: User, onResult: (Boolean) -> Unit)

}