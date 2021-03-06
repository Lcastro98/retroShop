package com.misionTIC.retroshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "products")
data class Product(
    @PrimaryKey var id: String ="",
    var name: String?="",
    var description: String?="",
    var image: String?="",
    var price: String?=""
){
    constructor(): this("","","","",""){}
}