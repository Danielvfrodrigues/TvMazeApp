package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.entity.ShowEntity
import com.example.myapplication.domain.repository.ShowRepository
import com.example.myapplication.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal interface GetEntireShowListUseCase {

    operator fun invoke(): Flow<Result<List<ShowEntity>>>
}

internal class GetEntireShowListUseCaseImpl constructor(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val showRepository: ShowRepository
) : GetEntireShowListUseCase {

    override fun invoke(): Flow<Result<List<ShowEntity>>> {
        return flow {
            emit(showRepository.getEntireShowList())
        }.catch {
            emit(Result.Failure(it))
        }.flowOn(coroutineDispatcher)
    }
}