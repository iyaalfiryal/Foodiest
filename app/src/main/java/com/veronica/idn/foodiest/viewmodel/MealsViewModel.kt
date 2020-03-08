package com.veronica.idn.foodiest.viewmodel

import com.veronica.idn.foodiest.AppBaseInterface
import com.veronica.idn.foodiest.model.food.MealsItem

class MealsViewModel (private var view:AppBaseInterface<List<MealsItem>>?): OnFinishedListener<List<MealsItem>>{

    override fun success(data: List<MealsItem>) {
        view?.hideProgressBar()
        view?.showData()
    }

    override fun failure(message: String?) {
        view?.hideProgressBar()
        view?.showError(message)
    }
}