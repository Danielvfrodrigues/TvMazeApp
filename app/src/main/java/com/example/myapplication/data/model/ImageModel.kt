package com.example.myapplication.data.model

import com.example.myapplication.domain.entity.ImageEntity
import com.google.gson.annotations.SerializedName

internal data class ImageModel (

    @SerializedName("medium")
    val medium: String = "",
    @SerializedName("original")
    val original: String = ""

)

@Throws(NumberFormatException::class)
internal fun ImageModel.toEntity(): ImageEntity {
    return ImageEntity(
        medium = medium,
        original = original
    )
}
