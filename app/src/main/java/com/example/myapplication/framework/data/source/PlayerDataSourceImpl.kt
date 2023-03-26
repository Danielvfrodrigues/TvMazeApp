package com.example.myapplication.framework.data.source

import com.example.myapplication.data.model.PlayerModel
import com.example.myapplication.data.service.PlayerService
import com.example.myapplication.data.source.PlayerDataSource
import kotlinx.coroutines.delay
import retrofit2.Response
import retrofit2.Retrofit

internal class PlayerDataSourceImpl constructor(
    retrofit: Retrofit
) : PlayerDataSource {

    private val playerService: PlayerService by lazy {
        retrofit.create(PlayerService::class.java)
    }

    override suspend fun getPlayerById(id: Int): Response<PlayerModel> {
        // return playerService.getPlayerById(id)
        delay(5_000)
        return Response.success(
            PlayerModel(
                id = "1",
                name = "Lucas"
            )
        )
    }
}
