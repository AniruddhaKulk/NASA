package com.anikulki.nasa.model

class NasaModel : ArrayList<NASAImagesItem>()

data class NASAImagesItem(
    val copyright: String?,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)