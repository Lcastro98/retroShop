package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.mockups.ProductMock

class ProductRepository(private val dataSource: ProductMock) {
    suspend fun loadProducts(): List<Product>{
        return dataSource.loadProducts()
    }
}