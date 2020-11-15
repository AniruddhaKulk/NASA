package com.anikulki.nasa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anikulki.nasa.model.NASAImagesItem
import com.anikulki.nasa.repository.NasaRepository

class SharedViewModel(private val repository: NasaRepository): ViewModel(){
    private val _nasaImagesListLiveData = MutableLiveData<List<NASAImagesItem>>()

    val nasaImagesListLiveData: LiveData<List<NASAImagesItem>>
        get() = _nasaImagesListLiveData

    private val _nasaImagePagerNavigation = MutableLiveData<Int>()

    val nasaImagePagerNavigation: LiveData<Int>
        get() = _nasaImagePagerNavigation

    init {
        getNasaImagesList()
    }

    private fun getNasaImagesList(){
        val data = repository.getNasaImagesList()
        _nasaImagesListLiveData.value = data
    }

    fun navigateToImagePagerScreen(currentPosition: Int){
        _nasaImagePagerNavigation.value = currentPosition
    }
}