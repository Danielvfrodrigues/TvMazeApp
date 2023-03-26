package com.example.myapplication.domain.repository

import com.example.myapplication.domain.entity.PlayerEntity
import com.example.myapplication.domain.util.Result

internal interface PlayerRepository {

    suspend fun getPlayerById(id: Int): Result<PlayerEntity>
}
