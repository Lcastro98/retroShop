package com.misionTIC.retroshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.misionTIC.retroshop.data.models.Comment


@Dao
interface CommentDao {
    @Insert
    suspend fun insertComment(comment: List<Comment>)

    @Query("SELECT * FROM comments")
    suspend fun getAllComments(): List<Comment>


}