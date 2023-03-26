package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.entity.PlayerEntity
import com.example.myapplication.domain.repository.PlayerRepository
import com.example.myapplication.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal interface GetPlayerByIdUseCase {

    operator fun invoke(id: Int): Flow<Result<PlayerEntity>>
}

internal class GetPlayerByIdUseCaseImpl constructor(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val playerRepository: PlayerRepository
) : GetPlayerByIdUseCase {

    override fun invoke(id: Int): Flow<Result<PlayerEntity>> {
        return flow {
            emit(playerRepository.getPlayerById(id))
        }.catch {
            emit(Result.Failure(it))
        }.flowOn(coroutineDispatcher)
    }
}
