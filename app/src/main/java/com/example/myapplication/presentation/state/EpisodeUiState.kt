package com.example.myapplication.presentation.state

import com.example.myapplication.domain.entity.EpisodeEntity
import com.example.myapplication.domain.entity.PlayerEntity

internal sealed class EpisodeUiState {

    internal data class Failure constructor(
        val throwable: Throwable? = null
    ) : EpisodeUiState()

    internal object Loading : EpisodeUiState()

    internal data class Success constructor(
        val episodeEntity: List<EpisodeEntity>
    ) : EpisodeUiState()
}
