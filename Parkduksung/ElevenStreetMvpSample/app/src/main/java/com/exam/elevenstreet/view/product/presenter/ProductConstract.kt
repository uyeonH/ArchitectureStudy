package com.exam.elevenstreet.view.product.presenter

import com.example.elevenstreet.ProductResponse

interface ProductConstract {
    interface View {
        fun showStartProductList(productList: List<ProductResponse>)
        fun showSearchProductList(productList: List<ProductResponse>)
    }

    interface Presenter {
        fun searchByKeyword(keyword: String)
        fun showStart()
    }

}

