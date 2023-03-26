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

internal interface GetShowByNameUseCase {

    operator fun invoke(name: String): Flow<Result<ShowEntity>>
}

internal class GetShowByNameUseCaseImpl constructor(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val showRepository: ShowRepository
) : GetShowByNameUseCase {

    override fun invoke(name: String): Flow<Result<ShowEntity>> {
        return flow {
            emit(showRepository.searchShow(name))
        }.catch {
            emit(Result.Failure(it))
        }.flowOn(coroutineDispatcher)
    }
}