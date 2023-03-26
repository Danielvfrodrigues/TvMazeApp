package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.entity.EpisodeEntity
import com.example.myapplication.domain.repository.EpisodeRepository
import com.example.myapplication.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal interface GetEpisodeListByShowIdUseCase {

    operator fun invoke(id: Int): Flow<Result<List<EpisodeEntity>>>
}

internal class GetEpisodeListByShowIdUseCaseImpl constructor(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val episodeRepository: EpisodeRepository
) : GetEpisodeListByShowIdUseCase {

    override fun invoke(id: Int): Flow<Result<List<EpisodeEntity>>> {
        return flow {
            emit(episodeRepository.getEpisodeListByShowId(id))
        }.catch {
            emit(Result.Failure(it))
        }.flowOn(coroutineDispatcher)
    }
}