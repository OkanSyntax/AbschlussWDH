package com.example.di_navi_wdh.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.di_navi_wdh.data.model.Animal
import com.example.di_navi_wdh.data.repository.AnimalRepoImpl


class HomeViewModel(
    animalRepo: AnimalRepoImpl
): ViewModel() {


    private val repo = animalRepo
    val animalList = repo.animalList

    fun toggleFavorite(animal: Animal) {
        repo.toggleFavorite(animal)
    }
}