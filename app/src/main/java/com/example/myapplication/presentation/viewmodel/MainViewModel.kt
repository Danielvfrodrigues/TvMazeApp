package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecase.GetEntireShowListUseCase
import com.example.myapplication.domain.usecase.GetEpisodeListByShowIdUseCase
import com.example.myapplication.domain.usecase.GetPlayerByIdUseCase
import com.example.myapplication.domain.usecase.GetShowByNameUseCase
import com.example.myapplication.domain.util.Result
import com.example.myapplication.presentation.state.EpisodeUiState
import com.example.myapplication.presentation.state.PlayerUiState
import com.example.myapplication.presentation.state.ShowUiState
import kotlinx.coroutines.flow.*

internal class MainViewModel constructor(
    private val getPlayerByIdUseCase: GetPlayerByIdUseCase,
    private val getEntireShowListUseCase: GetEntireShowListUseCase,
    private val getEpisodeListByShowIdUseCase: GetEpisodeListByShowIdUseCase,
    private val getShowByNameUseCase: GetShowByNameUseCase
) : ViewModel() {

    fun getPlayerByIdStateFlow(id: Int): StateFlow<PlayerUiState> {
        return getPlayerByIdFlow(id).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PlayerUiState.Loading
        )
    }

    fun getShowByQueryStateFlow(query: String): StateFlow<ShowUiState> {
        return getShowByQueryFlow(query).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ShowUiState.Loading
        )
    }

    fun getEpisodeListByShowIdStateFlow(id: Int): StateFlow<EpisodeUiState> {
        return getEpisodeListByShowIdFlow(id).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = EpisodeUiState.Loading
        )
    }

    private fun getPlayerByIdFlow(id: Int): Flow<PlayerUiState> {
        return getPlayerByIdUseCase(id).map {
            when (it) {
                is Result.Success -> {
                    PlayerUiState.Success(it.value)
                }
                is Result.Failure -> {
                    PlayerUiState.Failure(it.throwable)
                }
            }
        }.onStart {
            emit(PlayerUiState.Loading)
        }
    }

    private fun getShowByQueryFlow(query: String): Flow<ShowUiState> {
        return getShowByNameUseCase(query).map {
            when (it) {
                is Result.Success -> {
                    ShowUiState.Success(it.value)
                }
                is Result.Failure -> {
                    ShowUiState.Failure(it.throwable)
                }
            }
        }.onStart {
            emit(ShowUiState.Loading)
        }
    }

    private fun getEpisodeListByShowIdFlow(id: Int): Flow<EpisodeUiState> {
        return getEpisodeListByShowIdUseCase(id).map {
            when (it) {
                is Result.Success -> {
                    EpisodeUiState.Success(it.value)
                }
                is Result.Failure -> {
                    EpisodeUiState.Failure(it.throwable)
                }
            }
        }.onStart {
            emit(EpisodeUiState.Loading)
        }
    }
}
