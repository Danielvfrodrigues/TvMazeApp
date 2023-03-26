package com.example.myapplication.data.service

import com.example.myapplication.data.model.PlayerModel
import com.example.myapplication.data.util.API_ENDPOINT_PLAYER_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlayerService {

    @GET(API_ENDPOINT_PLAYER_ID)
    suspend fun getPlayerById(
        @Query(":id") id: Int
    ): Response<PlayerModel>
}
