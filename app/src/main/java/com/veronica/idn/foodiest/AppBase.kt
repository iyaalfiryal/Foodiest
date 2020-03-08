package com.veronica.idn.foodiest

import com.veronica.idn.foodiest.model.food.ResponseFoods


interface AppBaseInterface {
    fun hideProgressBar(isLoading: Boolean)
    fun sucess(data:List<ResponseFoods>)
    fun showError(message: String?)
}