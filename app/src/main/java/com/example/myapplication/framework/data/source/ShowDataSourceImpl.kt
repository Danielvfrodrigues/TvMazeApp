package com.example.myapplication.framework.data.source

import com.example.myapplication.data.model.ShowModel
import com.example.myapplication.data.service.RetrofitService
import com.example.myapplication.data.source.ShowDataSource
import retrofit2.Response
import retrofit2.Retrofit

internal class ShowDataSourceImpl constructor(
    retrofit: Retrofit
) : ShowDataSource {

    private val service: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }

    override suspend fun searchShow(query: String): Response<ShowModel> {
        return service.searchShow(query)
    }
}