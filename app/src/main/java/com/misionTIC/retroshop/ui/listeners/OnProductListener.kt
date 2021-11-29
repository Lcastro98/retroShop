package com.misionTIC.retroshop.ui.listeners

import com.misionTIC.retroshop.data.models.Product

interface OnProductListener {
    fun onClick(item: Product)
}