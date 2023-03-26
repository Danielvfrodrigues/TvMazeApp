package com.example.myapplication.data.source

import com.example.myapplication.data.model.ShowModel
import retrofit2.Response

internal interface ShowDataSource {

    suspend fun getEntireShowList(): Response<List<ShowModel>>
    suspend fun searchShow(query: String): Response<ShowModel>
}