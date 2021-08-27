package com.omelchenkoaleks.animals.screens.add

import androidx.lifecycle.*
import com.omelchenkoaleks.animals.database.AnimalRepository
import com.omelchenkoaleks.animals.model.Animal
import kotlinx.coroutines.launch

class AddAnimalViwModel(private val repository: AnimalRepository) : ViewModel() {

    fun insert(animal: Animal) = viewModelScope.launch {
        repository.insert(animal)
    }

}

class AddAnimalViewModelFactory(private val repository: AnimalRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddAnimalViwModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddAnimalViwModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
