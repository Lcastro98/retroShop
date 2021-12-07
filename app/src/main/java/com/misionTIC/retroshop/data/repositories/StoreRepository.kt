package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.database.dao.StoreDao
import com.misionTIC.retroshop.data.mockups.StoreInfoMock
import com.misionTIC.retroshop.data.models.StoreInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StoreRepository (private val dataSource: StoreInfoMock, private val dataSourceDb: StoreDao){
    suspend fun loadInfo(): StoreInfo? {
        return withContext(Dispatchers.IO) {
            dataSourceDb.getStore()
        }
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