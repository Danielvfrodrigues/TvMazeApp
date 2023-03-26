package com.example.myapplication.data.repository

import com.example.myapplication.data.model.ShowModel
import com.example.myapplication.data.model.toEntity
import com.example.myapplication.data.model.toShowEntityList
import com.example.myapplication.data.source.ShowDataSource
import com.example.myapplication.domain.entity.ShowEntity
import com.example.myapplication.domain.repository.ShowRepository
import com.example.myapplication.domain.util.Result
import retrofit2.Response

internal class ShowRepositoryImpl constructor(
    private val showDataSource: ShowDataSource
) : ShowRepository {

    override suspend fun getEntireShowList(): Result<List<ShowEntity>> {
        return try {
            val response: Response<List<ShowModel>> = showDataSource.getEntireShowList()
            if (response.isSuccessful) {
                val showModelList: List<ShowModel> = response.body() ?: return Result.Failure()
                Result.Success(toShowEntityList(showModelList))
            } else {
                Result.Failure()
            }
        } catch (e: Exception) {
            Result.Failure()
        }
    }

    override suspend fun searchShow(query: String): Result<ShowEntity> {
        return try {
            val response: Response<ShowModel> = showDataSource.searchShow(query)
            if (response.isSuccessful) {
                val showModel: ShowModel = response.body() ?: return Result.Failure()
                Result.Success(toEntity(showModel))
            } else {
                Result.Failure()
            }
        } catch (e: Exception) {
            Result.Failure()
        }
    }
}