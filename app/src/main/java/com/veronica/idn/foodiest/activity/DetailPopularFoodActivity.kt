package com.veronica.idn.foodiest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.veronica.idn.foodiest.R
import com.veronica.idn.foodiest.fragment.HomeFragment
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

        supportActionBar?.hide()

        fetchData()
        backStage()

    }

    private fun backStage() {

        iv_backstage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchData() {
        foods = intent.getParcelableExtra(KEY_POPULAR_FOOD)

        tv_name_detail_popular.text = foods?.name
        tv_name_detail_in_popular.text = foods?.name
        tv_kind_food_detail.text = foods?.kind
        tv_address_food_detail.text = foods?.address
        tv_desc_food_detail.text = foods?.des
        tv_price.text = foods?.price
        Glide.with(this).load(foods?.images)
            .apply(RequestOptions().override(900, 500))
            .into(iv_image_detail_popular)
    }


}
