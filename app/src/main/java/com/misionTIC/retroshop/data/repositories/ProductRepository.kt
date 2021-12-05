package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.database.dao.ProductDao
import com.misionTIC.retroshop.data.mockups.ProductMock
import com.misionTIC.retroshop.data.models.Product

class ProductRepository(private val dataSource: ProductMock, private val dataSourceDb: ProductDao) {
    suspend fun loadProducts(): List<Product>{
 //       return dataSource.loadProducts()
        return dataSourceDb.getAllProducts()
    }
    suspend fun insertProducts (products: List<Product>){
        val temp = dataSourceDb.getAllProducts()
        if(temp.isEmpty()){
            dataSourceDb.insertProducts(products)
        }
    }
}