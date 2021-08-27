package com.omelchenkoaleks.animals.database

import com.omelchenkoaleks.animals.model.Animal
import kotlinx.coroutines.flow.Flow

class AnimalRepository(private val animalDao: AnimalDao) {

    val allAnimals: Flow<List<Animal>> = animalDao.getAllAnimals()

    suspend fun insert(animal: Animal) {
        animalDao.insert(animal)
    }
}