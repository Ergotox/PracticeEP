package com.example.practiceep.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class ProductEntity (
    @PrimaryKey val id: Int
)