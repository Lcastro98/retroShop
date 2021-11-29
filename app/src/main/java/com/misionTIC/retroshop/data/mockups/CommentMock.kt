package com.misionTIC.retroshop.data.mockups

import com.misionTIC.retroshop.ui.adapters.Comment

class CommentMock {
    fun loadComments(): List<Comment>{
        return listOf(
            Comment("1","Literal algo que comentaron","pepito","url","2020-25-01"),
            Comment("2","Otro comentario", "pepito", "url", "2020-12-01")
        )
    }
}