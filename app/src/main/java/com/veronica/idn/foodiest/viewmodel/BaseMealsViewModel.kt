package com.veronica.idn.foodiest.viewmodel

import com.veronica.idn.foodiest.model.food.MealsItem
import com.veronica.idn.foodiest.model.food.ResponseFoods
import com.veronica.idn.foodiest.sources.RetrofitConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BaseMealsViewModel(private val listener:OnFinishedListener<List<MealsItem>>) {
    private val compositeDisposable = CompositeDisposable()
    fun fetchMealsData(){
        compositeDisposable.add(
            RetrofitConfig.apiServicesClient
                .getListFood()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleNext, this::handleError)
        )
    }
    private fun handleNext(mealItem : ResponseFoods){
        val mealsItem = mealItem.meals
        listener.success(mealsItem as List<MealsItem>)
    }

    private fun handleError(throwable: Throwable){
        listener.failure(throwable.message)
    }
}






