package com.omelchenkoaleks.animals.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_table")
data class Animal(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo val name: String = "",
    @ColumnInfo val age: Int = 0,
    @ColumnInfo val breed: String = ""
)