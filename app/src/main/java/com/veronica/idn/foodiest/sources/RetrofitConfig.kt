package com.veronica.idn.foodiest.sources

import com.veronica.idn.foodiest.common.Constant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    private val retrofitConfiguration by lazy {
        Retrofit.Builder().baseUrl(Constant().BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiServicesClient: ApiServices by lazy {
        retrofitConfiguration.create(ApiServices::class.java)
    }
}