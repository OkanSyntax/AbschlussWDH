package com.example.di_navi_wdh.di

import com.example.di_navi_wdh.data.repository.AnimalRepoImpl
import com.example.di_navi_wdh.ui.viewmodel.FavoriteViewModel
import com.example.di_navi_wdh.ui.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {

    single { AnimalRepoImpl() }

    viewModelOf(::HomeViewModel)
    viewModelOf(::FavoriteViewModel)

}