package com.misionTIC.retroshop.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.misionTIC.retroshop.data.models.Comment
import com.misionTIC.retroshop.data.models.Product
import com.misionTIC.retroshop.data.models.StoreInfo
import com.misionTIC.retroshop.data.repositories.StoreRepository
import com.misionTIC.retroshop.data.repositories.CommentRepository
import com.misionTIC.retroshop.data.repositories.ProductRepository
import kotlinx.coroutines.launch

class SplashViewModel(private val repoStore: StoreRepository, private val repoComment: CommentRepository,
    private val repoProduct: ProductRepository): ViewModel() {

        fun loadinformation(store: StoreInfo, comments: List<Comment>,products: List<Product>){
            viewModelScope.launch {
                repoStore.insertInfo(store)
                repoComment.insertComments(comments)
                repoProduct.insertProducts(products)
            }
        }
}