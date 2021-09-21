package com.omelchenkoaleks.animals.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.omelchenkoaleks.animals.model.Animal
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animal_table")
    fun getAllAnimals(): Flow<List<Animal>>

    @Query("SELECT * FROM animal_table ORDER BY name COLLATE NOCASE ASC")
    fun getListSortedByName(): Flow<List<Animal>>

    @Query("SELECT * FROM animal_table ORDER BY age ASC")
    fun getListSortedByAge(): Flow<List<Animal>>

    @Query("SELECT * FROM animal_table ORDER BY breed COLLATE NOCASE ASC")
    fun getListSortedByBreed(): Flow<List<Animal>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(animal: Animal)

    @Query("DELETE FROM animal_table")
    suspend fun deleteAll()

}