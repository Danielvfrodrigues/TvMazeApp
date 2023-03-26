package com.example.myapplication.domain.repository

import com.example.myapplication.domain.entity.ShowEntity
import com.example.myapplication.domain.util.Result


internal interface ShowRepository {

    suspend fun getEntireShowList(): Result<List<ShowEntity>>
    suspend fun searchShow(query: String): Result<ShowEntity>
}