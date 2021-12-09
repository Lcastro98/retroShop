package com.misionTIC.retroshop.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.misionTIC.retroshop.data.database.dao.ProductDao
import com.misionTIC.retroshop.data.mockups.ProductMock
import com.misionTIC.retroshop.data.models.Comment
import com.misionTIC.retroshop.data.models.Product
import com.misionTIC.retroshop.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProductRepository(private val dataSourceDb: ProductDao,
    private val dataSourceFirebase: FirebaseFirestore) {
    val db: CollectionReference =  dataSourceFirebase.collection(Constants.PRODUCT_COLLECTION)
    suspend fun loadProducts(): List<Product>{
        val snapshot = db.get().await()
        return snapshot.toObjects(Product::class.java)
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