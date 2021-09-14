package com.omelchenkoaleks.animals.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.omelchenkoaleks.animals.model.Animal
import com.omelchenkoaleks.animals.utils.listAnimals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Animal::class], version = 1)
abstract class AnimalDatabase : RoomDatabase() {

    abstract fun animalDao(): AnimalDao

    companion object {

        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        @Synchronized
        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): AnimalDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AnimalDatabase::class.java,
                    "animal_database"
                )
                    .addCallback(AnimalDatabaseCallback(scope))
                    .build()
                INSTANCE as AnimalDatabase
            } else INSTANCE as AnimalDatabase
        }

        private class AnimalDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.animalDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(animalDao: AnimalDao) {

            animalDao.deleteAll()

            for (animal in listAnimals) {
                animalDao.insert(animal)
            }
        }
    }
}