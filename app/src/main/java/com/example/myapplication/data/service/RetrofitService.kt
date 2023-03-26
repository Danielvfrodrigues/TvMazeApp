package com.example.myapplication.data.service

import com.example.myapplication.data.model.EpisodeModel
import com.example.myapplication.data.model.ShowModel
import com.example.myapplication.data.util.API_ENDPOINT_ENTIRE_SHOW_LIST
import com.example.myapplication.data.util.API_ENDPOINT_SEARCH_SHOW
import com.example.myapplication.data.util.API_ENDPOINT_SHOW_EPISODE_LIST
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RetrofitService {

    @GET(API_ENDPOINT_ENTIRE_SHOW_LIST)
    suspend fun fetchEntireShowList(): Response<List<ShowModel>>

    @GET(API_ENDPOINT_SHOW_EPISODE_LIST)
    suspend fun getEpisodeListByShowId(
        @Path("showId") showId: Int
    ): Response<List<EpisodeModel>>

    @GET(API_ENDPOINT_SEARCH_SHOW)
    suspend fun searchShow(
        @Query(":query") query: String
    ): Response<ShowModel>
}
