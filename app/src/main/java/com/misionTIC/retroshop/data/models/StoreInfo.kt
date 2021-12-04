package com.misionTIC.retroshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "stores")
data class StoreInfo(
    @PrimaryKey var id: String ="",
    var name: String?,
    var image: String?,
    var address: String?,
    var contact: String?,
    var description: String?,
    var lat: Double? = null,
    var lng: Double? = null
)