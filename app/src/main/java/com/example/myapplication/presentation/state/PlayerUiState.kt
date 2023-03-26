package com.example.myapplication.presentation.state

import com.example.myapplication.domain.entity.PlayerEntity

internal sealed class PlayerUiState {

    internal data class Failure constructor(
        val throwable: Throwable? = null
    ) : PlayerUiState()

    internal object Loading : PlayerUiState()

    internal data class Success constructor(
        val playerEntity: PlayerEntity
    ) : PlayerUiState()
}
