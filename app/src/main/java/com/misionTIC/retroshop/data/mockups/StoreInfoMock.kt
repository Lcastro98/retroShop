package com.misionTIC.retroshop.data.mockups

import com.misionTIC.retroshop.data.models.StoreInfo

class StoreInfoMock {
    fun loadInfo(): StoreInfo{
        return StoreInfo(
            "1",
            "RetroShop",
            "https://ingreseunadireccion.com",
            "Cra. tal # tal - tal",
            "Vendemos algo"
        )
    }
}