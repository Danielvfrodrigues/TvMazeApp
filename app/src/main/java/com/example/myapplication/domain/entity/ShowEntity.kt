package com.example.myapplication.domain.entity

internal data class ShowEntity constructor(

    val id: Int = 0,
    val name: String = "",
    val image: ImageEntity = ImageEntity(),
    val schedule: ScheduleEntity = ScheduleEntity(),
    val genres: GenresEntity = GenresEntity(),
    val summary: String? = null

)

internal data class ScheduleEntity(

    val time: String = "",
    val days: List<String> = listOf()

)

internal data class GenresEntity(

    val genres: List<String> = listOf()

)

