package com.example.myapplication.data.source

import com.example.myapplication.data.model.EpisodeModel
import retrofit2.Response

internal interface EpisodeDataSource {

    suspend fun getEpisodeListByShowId(id: Int): Response<List<EpisodeModel>>
}