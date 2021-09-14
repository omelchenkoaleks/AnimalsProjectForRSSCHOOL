package com.omelchenkoaleks.animals

import android.app.Application
import com.omelchenkoaleks.animals.database.AnimalDatabase
import com.omelchenkoaleks.animals.database.AnimalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AnimalsApplication: Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { AnimalDatabase.getInstance(this, applicationScope) }
    val repository by lazy { AnimalRepository(database.animalDao()) }
}