package com.misionTIC.retroshop.data.mockups

import com.misionTIC.retroshop.data.models.Comment

class CommentMock {
    fun loadComments(): List<Comment>{
        return listOf(
            Comment("1","buen producto", "Fulano", "https://st.depositphotos.com/2069323/2156/i/950/depositphotos_21568785-stock-photo-man-pointing.jpg", "2020-05-01"),
            Comment("2","buen producto", "Fulano", "https://st.depositphotos.com/2069323/2156/i/950/depositphotos_21568785-stock-photo-man-pointing.jpg", "2021-05-01")
        )
    }
}