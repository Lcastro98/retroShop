package com.misionTIC.retroshop.data.mockups

class CommentMock {
    fun loadComments(): List<Comment>{
        return listOf(
            Comment("1","Literal algo que comentaron"),
            Comment("2","Otro comentario")
        )
    }
}