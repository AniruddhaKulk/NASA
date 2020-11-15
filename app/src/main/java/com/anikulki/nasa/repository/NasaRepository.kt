package com.anikulki.nasa.repository

import com.anikulki.nasa.model.NASAImagesItem

interface NasaRepository {
    fun getNasaImagesList(): List<NASAImagesItem>
}