package com.misionTIC.retroshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.misionTIC.retroshop.data.models.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProducts(product: List<Product>)

    @Query ("SELECT * FROM product")
    suspend fun getAllProducts(): List<Product>

}