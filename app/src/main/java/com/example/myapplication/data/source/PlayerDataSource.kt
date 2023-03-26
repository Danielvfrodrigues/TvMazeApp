package com.example.myapplication.data.source

import com.example.myapplication.data.model.PlayerModel
import retrofit2.Response

internal interface PlayerDataSource {

    suspend fun getPlayerById(id: Int): Response<PlayerModel>
}
