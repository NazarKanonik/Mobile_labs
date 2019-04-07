package com.kanonik.cb.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.kanonik.cb.data.database.dao.CategoryDao
import com.kanonik.cb.data.database.dao.DrinkDao
import com.kanonik.cb.data.database.dao.IngredientDao
import com.kanonik.cb.model.Category
import com.kanonik.cb.model.Drink
import com.kanonik.cb.model.Ingredient

@Database(entities = [Drink::class, Category::class, Ingredient::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val drinkDao: DrinkDao
    abstract val categoryDao: CategoryDao
    abstract val ingredientDao: IngredientDao

    companion object {

        private var instance: RoomDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return instance as AppDatabase
        }
    }
}