package com.misionTIC.retroshop.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.misionTIC.retroshop.data.database.dao.StoreDao
import com.misionTIC.retroshop.data.mockups.StoreInfoMock
import com.misionTIC.retroshop.data.models.Product
import com.misionTIC.retroshop.data.models.StoreInfo
import com.misionTIC.retroshop.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class StoreRepository (private val dataSource: StoreInfoMock, private val dataSourceDb: StoreDao,
    private val dataSourceFirebase: FirebaseFirestore){
    val db: CollectionReference =  dataSourceFirebase.collection(Constants.STORE_COLLECTION)
    suspend fun loadInfo(): StoreInfo? {
        val snapshot = db.get().await()
        return snapshot.toObjects(StoreInfo::class.java)[0]
    }
    suspend fun insertInfo(store: StoreInfo) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getStore()
            if (temp == null) {
                dataSourceDb.insertStore(store)
            }
        }
    }
}