package com.misionTIC.retroshop.data.repositories

import com.misionTIC.retroshop.data.database.dao.CommentDao
import com.misionTIC.retroshop.data.mockups.CommentMock
import com.misionTIC.retroshop.data.models.Comment

class CommentRepository (private val dataSource: CommentMock,private val dataSourceDb: CommentDao){
    suspend fun loadComments(): List<Comment>{
  //      return dataSource.loadComments()
        return dataSourceDb.getAllComments()
    }
    suspend fun insertComments(comments: List<Comment>){
        val temp = dataSourceDb.getAllComments()
        if(temp.isEmpty()){
            dataSourceDb.insertComments(comments)
        }
    }
}