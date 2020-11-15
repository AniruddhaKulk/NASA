package com.anikulki.nasa.utils

sealed class State <T> {

    /**
     * Returns [State.Loading] instance.
     */
    class Loading<T>(val isLoading: Boolean): State<T>()

    /**
     * Returns [State.Success] instance.
     * @param data Data to emit with status.
     */

    data class Success<T>(val data: T): State<T>()

    /**
     * Returns [State.Error] instance.
     * @param message Description of failure.
     */

    data class Error<T>(val errorMessage: String): State<T>()

    companion object {
        fun<T> loading(isLoading: Boolean) = Loading<T>(isLoading)

        fun<T> success(data: T) = Success(data)

        fun<T> error(errorMessage: String) = Error<T>(errorMessage)
    }
}