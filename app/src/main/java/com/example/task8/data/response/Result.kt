package com.example.task8.data.response

import com.example.task8.data.model.User

sealed class Result {
    data class Error(val throwable: Throwable): Result()
    data class Success(val data: User):Result()
}