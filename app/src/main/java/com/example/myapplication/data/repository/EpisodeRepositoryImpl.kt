package com.example.myapplication.data.repository

import com.example.myapplication.data.model.EpisodeModel
import com.example.myapplication.data.model.toEpisodeEntityList
import com.example.myapplication.data.source.EpisodeDataSource
import com.example.myapplication.domain.entity.EpisodeEntity
import com.example.myapplication.domain.repository.EpisodeRepository
import com.example.myapplication.domain.util.Result
import retrofit2.Response

internal class EpisodeRepositoryImpl constructor(
    private val episodeDataSource: EpisodeDataSource
) : EpisodeRepository {

    override suspend fun getEpisodeListByShowId(id: Int): Result<List<EpisodeEntity>> {
        return try {
            val response: Response<List<EpisodeModel>> = episodeDataSource.getEpisodeListByShowId(id)
            if (response.isSuccessful) {
                val episodeModelList: List<EpisodeModel> = response.body() ?: return Result.Failure()
                Result.Success(toEpisodeEntityList(episodeModelList))
            } else {
                Result.Failure()
            }
        } catch (e: Exception) {
            Result.Failure()
        }
    }
}