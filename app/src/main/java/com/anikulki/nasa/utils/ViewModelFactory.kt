package com.anikulki.nasa.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anikulki.nasa.SharedViewModel
import com.anikulki.nasa.repository.NasaRepositoryImpl
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SharedViewModel::class.java)){
            return SharedViewModel(NasaRepositoryImpl()) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}