package com.misionTIC.retroshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.misionTIC.retroshop.data.models.StoreInfo


@Dao
interface StoreDao {

    @Insert
    suspend fun insertStore(store: StoreInfo)

    @Query("SELECT * FROM stores LIMIT 1")
    suspend fun getStore(): StoreInfo?
}