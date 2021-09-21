package com.omelchenkoaleks.animals.database

import androidx.preference.PreferenceManager
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.model.Animal
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY
import kotlinx.coroutines.flow.Flow

class AnimalRepository(private val animalDao: AnimalDao) {

    private val preference = PreferenceManager.getDefaultSharedPreferences(APP_ACTIVITY)
    private val isName = preference.getBoolean(APP_ACTIVITY.getString(R.string.key_name), false)
    private val isAge = preference.getBoolean(APP_ACTIVITY.getString(R.string.key_age), false)
    private val isBreed = preference.getBoolean(APP_ACTIVITY.getString(R.string.key_breed), false)


    val allAnimals: Flow<List<Animal>> = when {
        isName -> animalDao.getListSortedByName()
        isAge -> animalDao.getListSortedByAge()
        isBreed -> animalDao.getListSortedByBreed()
        else -> animalDao.getAllAnimals()
    }

    suspend fun insert(animal: Animal) {
        animalDao.insert(animal)
    }
}