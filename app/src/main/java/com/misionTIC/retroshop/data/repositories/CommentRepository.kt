package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.database.dao.CommentDao
import com.misionTIC.retroshop.data.mockups.CommentMock
import com.misionTIC.retroshop.data.models.Comment
import kotlinx.coroutines.*



class CommentRepository(val dataSource: CommentMock, private val dataSourceDb: CommentDao) {
    suspend fun loadComments(): List<Comment> {
        return withContext(Dispatchers.IO) {
            dataSourceDb.getAllComments()
        }
    }

    suspend fun insertComments(comments: List<Comment>) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getAllComments()
            if (temp.isEmpty()) {
                dataSourceDb.insertComments(comments)
            }
        }
    }
}