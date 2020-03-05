package com.veronica.idn.foodiest.sources

import android.database.Observable
import com.veronica.idn.foodiest.model.food.ResponseFoods
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiServices {
    @GET ("filter.php?c=Seafood")
    fun getListFood():io.reactivex.Observable<ResponseFoods>
//    fun getListFood(@Query ("c")category: String):io.reactivex.Observable<ResponseFoods>
}