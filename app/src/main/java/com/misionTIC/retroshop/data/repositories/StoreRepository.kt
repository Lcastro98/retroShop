package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.mockups.StoreInfoMock
import com.misionTIC.retroshop.data.models.StoreInfo

class StoreRepository (private val dataSource: StoreInfoMock){
    suspend fun loadInfo(): StoreInfo{
        return dataSource.loadInfo()
    }
}