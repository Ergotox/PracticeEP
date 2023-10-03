package com.example.practiceep.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practiceep.data.model.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao():ProductDao

    companion object{
        fun getInstance(context: Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, "product_compose_db")
                .allowMainThreadQueries()
                .build()
        }
    }
}