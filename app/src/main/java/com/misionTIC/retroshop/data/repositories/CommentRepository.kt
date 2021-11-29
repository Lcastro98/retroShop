package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.mockups.CommentMock
import com.misionTIC.retroshop.data.models.Comment

class CommentRepository (private val dataSource: CommentMock){
    suspend fun loadComments(): List<Comment>{
        return dataSource.loadComments()
    }
}