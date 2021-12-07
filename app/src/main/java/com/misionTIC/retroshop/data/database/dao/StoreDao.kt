package com.misionTIC.retroshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.misionTIC.retroshop.data.models.StoreInfo


@Dao
interface StoreDao {

    @Insert
     fun insertStore(store: StoreInfo)

    @Query("SELECT * FROM stores LIMIT 1")
     fun getStore(): StoreInfo?
}