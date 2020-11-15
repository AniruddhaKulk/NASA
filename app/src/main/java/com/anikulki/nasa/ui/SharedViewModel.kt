package com.anikulki.nasa.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anikulki.nasa.model.NASAImagesItem
import com.anikulki.nasa.repository.NasaRepository
import com.anikulki.nasa.utils.Event
import com.anikulki.nasa.utils.State

class SharedViewModel(private val repository: NasaRepository): ViewModel(){
    private val _nasaImagesListLiveData = MutableLiveData<State<List<NASAImagesItem>>>()

    val nasaImagesListLiveData: LiveData<State<List<NASAImagesItem>>>
        get() = _nasaImagesListLiveData

    private val _nasaImagePagerNavigation = MutableLiveData<Event<Int>>()

    val nasaImagePagerNavigation: LiveData<Event<Int>>
        get() = _nasaImagePagerNavigation

    init {
        getNasaImagesList()
    }

    private fun getNasaImagesList(){
        _nasaImagesListLiveData.value = State.loading()
        val data = repository.getNasaImagesList()
        if(data.isEmpty()) {
            _nasaImagesListLiveData.value = State.error("Could not get the data")
        }else{
            _nasaImagesListLiveData.value = State.success(data)
        }
    }

    fun navigateToImagePagerScreen(currentPosition: Int){
        _nasaImagePagerNavigation.value = Event(currentPosition)
    }
}