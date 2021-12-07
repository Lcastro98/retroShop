package com.misionTIC.retroshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName= "comments")

data class Comment(
    @PrimaryKey var id: String = "",
    var description: String? = "",
    var author: String? = "",
    var image: String? = "",
    var date: String? = ""
)
