package com.example.myapplication.presentation.state

import com.example.myapplication.domain.entity.PlayerEntity
import com.example.myapplication.domain.entity.ShowEntity

internal sealed class ShowUiState {

    internal data class Failure constructor(
        val throwable: Throwable? = null
    ) : ShowUiState()

    internal object Loading : ShowUiState()

    internal data class Success constructor(
        val showEntity: ShowEntity
    ) : ShowUiState()
}
