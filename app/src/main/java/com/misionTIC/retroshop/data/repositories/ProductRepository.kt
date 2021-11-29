package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.mockups.ProductMock
import com.misionTIC.retroshop.ui.adapters.Product

class ProductRepository(private val dataSource: ProductMock) {
    suspend fun loadProducts(): List<Product>{
        return dataSource.loadProducts()
    }
}