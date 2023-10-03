package com.example.practiceep.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.practiceep.data.model.ProductEntity

@Dao
interface ProductDao {
    @Insert
    fun save(product: ProductEntity)
    @Delete
    fun delete(product: ProductEntity)
    @Query("select * from products")
    fun getAll(): List<ProductEntity>
    @Query("select * from products where id = :id")
    fun getById(id: Int):ProductEntity?
}