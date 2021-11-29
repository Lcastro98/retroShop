package com.misionTIC.retroshop.data.mockups

import com.misionTIC.retroshop.data.models.StoreInfo

class StoreInfoMock {
    fun loadInfo(): StoreInfo{
        return StoreInfo(
            "1",
            "Mi tienda",
            "https://ingreseunadireccion.com",
            "calle Falsa 123",
            "Vendemos algo"
        )
    }
}