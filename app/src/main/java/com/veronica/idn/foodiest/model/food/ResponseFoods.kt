package com.veronica.idn.foodiest.model.food

import com.google.gson.annotations.SerializedName

data class ResponseFoods(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null
)