package com.misionTIC.retroshop.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.misionTIC.retroshop.data.models.Comment

@Dao
interface CommentDao {
    @Insert
     suspend fun insertComments(comments: List<Comment>)

    @Query("SELECT * FROM comments")
    fun getAllComments(): List<Comment>
}