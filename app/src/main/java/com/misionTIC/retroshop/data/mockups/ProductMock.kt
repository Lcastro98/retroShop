package com.misionTIC.retroshop.data.mockups

class ProductMock {
    fun loadProducts(): List<Product>{
        return listOf(
            Product("1","Product 1","Alguna descripcion del producto","imagen","algun valor"),
            Product("2","Product 2","Alguna descripcion del producto","imagen","algun valor")
        )
    }

}