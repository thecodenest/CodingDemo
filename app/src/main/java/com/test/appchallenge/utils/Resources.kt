package com.test.appchallenge.utils

import java.lang.Exception

sealed class Resources<T>(
    val data: T? = null,
    val exception: Exception? = null
) {
    class Success<T>(data: T) : Resources<T>(data)
    class Error<T>(data: T?, e: Exception) : Resources<T>(data, e)
    class Loading<T> : Resources<T>()
}