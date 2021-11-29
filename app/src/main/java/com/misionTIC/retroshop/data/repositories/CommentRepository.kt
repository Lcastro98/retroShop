package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.mockups.CommentMock
import com.misionTIC.retroshop.ui.adapters.Comment

class CommentRepository (private val dataSource: CommentMock){
    suspend fun loadComment(): List<Comment>{
        return dataSource.loadComments()
    }
}