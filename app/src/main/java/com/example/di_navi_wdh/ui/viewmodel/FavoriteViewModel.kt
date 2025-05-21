package com.example.di_navi_wdh.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class FavoriteViewModel(homeViewModel: HomeViewModel): ViewModel() {

    val favoriteList = homeViewModel.animalList
        .map { list -> list.filter { it.isFavorite}}
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

}