package com.misionTIC.retroshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.misionTIC.retroshop.data.database.dao.CommentDao
import com.misionTIC.retroshop.data.database.dao.ProductDao
import com.misionTIC.retroshop.data.database.dao.StoreDao
import com.misionTIC.retroshop.data.models.Comment
import com.misionTIC.retroshop.data.models.Product
import com.misionTIC.retroshop.data.models.StoreInfo

@Database(entities=[Comment::class, Product::class, StoreInfo::class], version = 1)
abstract class AppDataBase: RoomDatabase () {
    abstract fun commentDao(): CommentDao
    abstract fun productDao(): ProductDao
    abstract fun storeDao(): StoreDao

}