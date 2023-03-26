package com.example.myapplication.data.repository

import com.example.myapplication.data.model.PlayerModel
import com.example.myapplication.data.model.toEntity
import com.example.myapplication.data.source.PlayerDataSource
import com.example.myapplication.domain.entity.PlayerEntity
import com.example.myapplication.domain.repository.PlayerRepository
import com.example.myapplication.domain.util.Result
import retrofit2.Response

internal class PlayerRepositoryImpl constructor(
    private val playerDataSource: PlayerDataSource
) : PlayerRepository {

    override suspend fun getPlayerById(id: Int): Result<PlayerEntity> {
        return try {
            val response: Response<PlayerModel> = playerDataSource.getPlayerById(id)
            if (response.isSuccessful) {
                val playerModel: PlayerModel = response.body() ?: return Result.Failure()
                Result.Success(playerModel.toEntity())
            } else {
                Result.Failure()
            }
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}
