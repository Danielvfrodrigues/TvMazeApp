package com.example.myapplication.domain.entity

internal data class EpisodeEntity constructor(

    val name: String = "",
    val number: Int = 0,
    val season: String = "",
    val summary: String = "",
    val image: ImageEntity = ImageEntity(),

)
