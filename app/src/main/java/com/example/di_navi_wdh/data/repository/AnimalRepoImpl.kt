package com.example.di_navi_wdh.data.repository

import com.example.di_navi_wdh.data.DummyData
import com.example.di_navi_wdh.data.model.Animal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class AnimalRepoImpl {

    private val _animalList = MutableStateFlow<List<Animal>>(DummyData.animals)
    val animalList = _animalList.asStateFlow()

    fun toggleFavorite(animal: Animal) {
        _animalList.value = _animalList.value.map {
            if (it.name == animal.name) it.copy(isFavorite = !it.isFavorite) else it
        }
    }
}