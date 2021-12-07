package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.database.dao.ProductDao
import com.misionTIC.retroshop.data.mockups.ProductMock
import com.misionTIC.retroshop.data.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(private val dataSource: ProductMock, private val dataSourceDb: ProductDao) {
    suspend fun loadProducts(): List<Product>{
        return withContext(Dispatchers.IO) {
            dataSourceDb.getAllProducts()
        }
    }
    suspend fun insertProducts (products: List<Product>){
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getAllProducts()
            if (temp.isEmpty()) {
                dataSourceDb.insertProducts(products)
            }
        }
    }
}