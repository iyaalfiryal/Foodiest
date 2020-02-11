package com.veronica.idn.foodiest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.veronica.idn.foodiest.R
import com.veronica.idn.foodiest.model.Foods
import kotlinx.android.synthetic.main.activity_detail_popular_food.*

class DetailPopularFoodActivity : AppCompatActivity() {

    companion object {
        const val KEY_POPULAR_FOOD = "key_popular_food"
    }

    private var foods: Foods? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_popular_food)
        foods = intent.getParcelableExtra(KEY_POPULAR_FOOD)

        tv_name_detail_popular.text = foods?.name
        tv_desc_detail_popular.text = foods?.kind
        Glide.with(this).load(foods?.images).apply(RequestOptions().override(500))
            .into(iv_image_detail_popular)

    }
}
