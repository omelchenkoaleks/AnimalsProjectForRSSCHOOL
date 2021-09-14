package com.omelchenkoaleks.animals.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.omelchenkoaleks.animals.database.AnimalRepository
import com.omelchenkoaleks.animals.model.Animal

class AnimalViewModel(private val repository: AnimalRepository) : ViewModel() {

    val allAnimals: LiveData<List<Animal>> = repository.allAnimals.asLiveData()

}

class AnimalViewModelFactory(private val repository: AnimalRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimalViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnimalViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
