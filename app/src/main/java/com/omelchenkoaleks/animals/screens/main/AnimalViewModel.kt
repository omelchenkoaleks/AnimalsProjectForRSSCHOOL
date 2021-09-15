package com.omelchenkoaleks.animals.screens.main

import androidx.lifecycle.*
import androidx.preference.PreferenceManager
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.database.AnimalRepository
import com.omelchenkoaleks.animals.model.Animal
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY

class AnimalViewModel(private val repository: AnimalRepository) : ViewModel() {

    var allAnimals: LiveData<List<Animal>> = repository.allAnimals.asLiveData()



    // TRIES TO )))
//    val animals = sortAnimals()
//
//    private fun sortAnimals(): LiveData<List<Animal>> {
//
//        val animals = MediatorLiveData<List<Animal>>()
//
//        val preference = PreferenceManager.getDefaultSharedPreferences(APP_ACTIVITY)
//        val isName = preference.getBoolean(APP_ACTIVITY.getString(R.string.key_name), false)
//        val isAge = preference.getBoolean(APP_ACTIVITY.getString(R.string.key_age), false)
//        val isBreed = preference.getBoolean(APP_ACTIVITY.getString(R.string.key_breed), false)
//
//        if (isName) {
//            animals.addSource(repository.allAnimals.asLiveData()) { list ->
//                list.sortedBy { it.name }
//
//            }
//        }
//
//        return animals
//    }

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
