package com.omelchenkoaleks.animals.database

import androidx.preference.PreferenceManager
import com.omelchenkoaleks.animals.model.Animal
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY
import kotlinx.coroutines.flow.Flow

class AnimalRepository(private val animalDao: AnimalDao) {

    private val prefs = PreferenceManager.getDefaultSharedPreferences(APP_ACTIVITY)
    val name = prefs.getString("key_name", "empty").toString()
    val age = prefs.getString("key_age", "empty").toString()
    val breed = prefs.getString("key_breed", "empty").toString()

    val allAnimals: Flow<List<Animal>> = when {
        name != "empty" && age != "empty" && breed != "empty" -> {
            animalDao.getAllAnimalsBySort(name, age, breed)
        }
        else -> {
            animalDao.getAllAnimals()
        }
    }

    suspend fun insert(animal: Animal) {
        animalDao.insert(animal)
    }
}