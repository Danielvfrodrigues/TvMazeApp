package com.example.myapplication.framework.data.source

import com.example.myapplication.data.model.EpisodeModel
import com.example.myapplication.data.service.RetrofitService
import com.example.myapplication.data.source.EpisodeDataSource
import retrofit2.Response
import retrofit2.Retrofit

internal class EpisodeDataSourceImpl constructor(
    retrofit: Retrofit
) : EpisodeDataSource {

    private val service: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }

    override suspend fun getEpisodeListByShowId(id: Int): Response<List<EpisodeModel>> {
        return service.getEpisodeListByShowId(id)
    }
}