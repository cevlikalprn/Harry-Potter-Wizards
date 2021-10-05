package com.cevlikalprn.harrypotterwizards.util

sealed class Result<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(data: T? = null, errorMessage: String?) : Result<T>(data, errorMessage)
    class Loading<T> : Result<T>()
}