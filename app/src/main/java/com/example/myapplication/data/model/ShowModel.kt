package com.example.myapplication.data.model

import com.example.myapplication.domain.entity.*
import com.example.myapplication.domain.entity.GenresEntity
import com.example.myapplication.domain.entity.ScheduleEntity
import com.example.myapplication.domain.entity.ShowEntity
import com.google.gson.annotations.SerializedName

internal data class ShowModel constructor(

    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("image")
    val image: ImageModel = ImageModel(),
    @SerializedName("schedule")
    val schedule: ScheduleModel = ScheduleModel(),
    @SerializedName("genres")
    val genres: GenresModel = GenresModel(),
    @SerializedName("summary")
    val summary: String = ""

)

internal data class ScheduleModel (

    @SerializedName("time")
    val time: String = "",
    @SerializedName("days")
    val days: List<String> = listOf()

)

internal data class GenresModel(

    @SerializedName("genres")
    val genres: List<String> = listOf()

)

@Throws(NumberFormatException::class)
internal fun toEntity(model: ShowModel): ShowEntity {
    return ShowEntity(
        id = model.id,
        name = model.name,
        image = model.image.toEntity(),
        schedule = ScheduleEntity(
            time = model.schedule.time,
            days = model.schedule.days
        ),
        genres = GenresEntity(
            genres = model.genres.genres
        ),
        summary = model.summary
    )
}

internal fun toShowEntityList(initial: List<ShowModel>): List<ShowEntity> {
    return initial.map { toEntity(it) }
}