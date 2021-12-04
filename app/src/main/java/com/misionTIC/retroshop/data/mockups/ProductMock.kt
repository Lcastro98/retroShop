package com.misionTIC.retroshop.data.mockups

import com.misionTIC.retroshop.data.models.Product

class ProductMock {
    fun loadProducts(): List<Product>{
        return listOf(
            Product("1","Product 1","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("2","Product 2","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("3","Product 3","Texto de prueba","http://lysisgroupdiag.blob.core.windows.net/image/arete.jpg","200000"),
            Product("4","Product 4","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("5","Product 5","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("6","Product 6","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("7","Product 7","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("8","Product 8","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("9","Product 9","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
            Product("10","Product 10","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000")
        )
    }

}