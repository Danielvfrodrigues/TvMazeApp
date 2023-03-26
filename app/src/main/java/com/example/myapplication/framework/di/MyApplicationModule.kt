package com.example.myapplication.framework.di

import com.example.myapplication.data.repository.EpisodeRepositoryImpl
import com.example.myapplication.data.repository.PlayerRepositoryImpl
import com.example.myapplication.data.repository.ShowRepositoryImpl
import com.example.myapplication.data.source.EpisodeDataSource
import com.example.myapplication.data.source.PlayerDataSource
import com.example.myapplication.data.source.ShowDataSource
import com.example.myapplication.domain.repository.EpisodeRepository
import com.example.myapplication.domain.repository.PlayerRepository
import com.example.myapplication.domain.repository.ShowRepository
import com.example.myapplication.domain.usecase.*
import com.example.myapplication.domain.usecase.GetEpisodeListByShowIdUseCase
import com.example.myapplication.domain.usecase.GetEpisodeListByShowIdUseCaseImpl
import com.example.myapplication.domain.usecase.GetPlayerByIdUseCase
import com.example.myapplication.domain.usecase.GetPlayerByIdUseCaseImpl
import com.example.myapplication.domain.usecase.GetShowByNameUseCase
import com.example.myapplication.framework.MyApplicationConnector
import com.example.myapplication.framework.data.source.EpisodeDataSourceImpl
import com.example.myapplication.framework.data.source.PlayerDataSourceImpl
import com.example.myapplication.framework.data.source.ShowDataSourceImpl
import com.example.myapplication.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal val myApplicationModule: Module = module {

    factory {
        MyApplicationConnector().getRetrofit()
    }

    factory<PlayerDataSource> {
        PlayerDataSourceImpl(
            retrofit = get()
        )
    }

    factory<ShowDataSource> {
        ShowDataSourceImpl(
            retrofit = get()
        )
    }

    factory<EpisodeDataSource> {
        EpisodeDataSourceImpl(
            retrofit = get()
        )
    }

    factory<PlayerRepository> {
        PlayerRepositoryImpl(
            playerDataSource = get()
        )
    }

    factory<ShowRepository> {
        ShowRepositoryImpl(
            showDataSource = get()
        )
    }

    factory<EpisodeRepository> {
        EpisodeRepositoryImpl(
            episodeDataSource = get()
        )
    }

    factory<GetPlayerByIdUseCase> {
        GetPlayerByIdUseCaseImpl(
            playerRepository = get()
        )
    }

    factory<GetEntireShowListUseCase> {
        GetEntireShowListUseCaseImpl(
             showRepository = get()
        )
    }

    factory<GetEpisodeListByShowIdUseCase> {
        GetEpisodeListByShowIdUseCaseImpl(
            episodeRepository = get()
        )
    }

    factory<GetShowByNameUseCaseImpl> {
        GetShowByNameUseCaseImpl(
            showRepository = get()
        )
    }

    viewModel {
        MainViewModel(
            getPlayerByIdUseCase = get(),
            getEntireShowListUseCase = get(),
            getEpisodeListByShowIdUseCase = get(),
            getShowByNameUseCase = get()
        )
    }
}
