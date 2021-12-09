package com.misionTIC.retroshop.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.misionTIC.retroshop.data.database.dao.CommentDao
import com.misionTIC.retroshop.data.mockups.CommentMock
import com.misionTIC.retroshop.data.models.Comment
import com.misionTIC.retroshop.utils.Constants
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await


class CommentRepository(val dataSource: CommentMock, private val dataSourceDb: CommentDao,
    private val dataSourceFirebase: FirebaseFirestore) {
    val db: CollectionReference =  dataSourceFirebase.collection(Constants.COMMENT_COLLECTION)
    suspend fun loadComments(): List<Comment> {
        val snapshot = db.get().await()
        return snapshot.toObjects(Comment::class.java)
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