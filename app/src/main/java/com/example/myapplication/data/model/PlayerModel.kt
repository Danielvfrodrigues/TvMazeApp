package com.example.myapplication.data.model

import com.example.myapplication.domain.entity.PlayerEntity
import com.google.gson.annotations.SerializedName

internal data class PlayerModel constructor(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)

@Throws(NumberFormatException::class)
internal fun PlayerModel.toEntity(): PlayerEntity {
    return PlayerEntity(
        id = id.toInt(),
        name = name
    )
}
