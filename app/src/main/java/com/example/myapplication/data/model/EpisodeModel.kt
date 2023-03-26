package com.example.myapplication.data.model

import com.example.myapplication.domain.entity.EpisodeEntity
import com.google.gson.annotations.SerializedName

internal data class EpisodeModel(

    @SerializedName("name")
    val name: String = "",
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("season")
    val season: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("image")
    val image: ImageModel = ImageModel(),

)

@Throws(NumberFormatException::class)
internal fun toEntity(model: EpisodeModel): EpisodeEntity {
    return EpisodeEntity(
        name = model.name,
        number = model.number,
        season = model.season,
        summary = model.summary,
        image = model.image.toEntity(),
    )
}

internal fun toEpisodeEntityList(initial: List<EpisodeModel>): List<EpisodeEntity> {
    return initial.map { toEntity(it) }
}

