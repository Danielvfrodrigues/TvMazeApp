package com.example.myapplication.domain.repository

import com.example.myapplication.domain.entity.EpisodeEntity
import com.example.myapplication.domain.util.Result

internal interface EpisodeRepository {

    suspend fun getEpisodeListByShowId(id: Int): Result<List<EpisodeEntity>>
}