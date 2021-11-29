package com.misionTIC.retroshop.data.mockups

import com.misionTIC.retroshop.data.models.StoreInfo

class StoreInfoMock {
    fun loadInfo(): StoreInfo{
        return StoreInfo(
            "1",
            "RetroShop",
            "https://i.postimg.cc/T1sN5Bb6/logo.png",
            "Cra. tal # tal - tal",
            "Nuestros contactos: +57 300 XXX XXXX 01 8000 23 53",
            "Nacimos en 2015 con el propósito de llevar lo que tu deseas a tu hogar"

        )
    }
}