package com.misionTIC.retroshop

import com.misionTIC.retroshop.ui.adapters.Product

interface OnProductListener {
    fun onClick(item: Product)
}