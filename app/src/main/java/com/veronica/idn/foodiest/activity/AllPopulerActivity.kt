package com.veronica.idn.foodiest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.veronica.idn.foodiest.R
import com.veronica.idn.foodiest.adapter.StaggeredAdapter
import com.veronica.idn.foodiest.model.Foods
import kotlinx.android.synthetic.main.activity_all_populer.*

class AllPopulerActivity : AppCompatActivity() {
    private val listFood = ArrayList<Foods>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_populer)
        rv_all_popular.setHasFixedSize(true)
        listFood.addAll(getListFood())
        supportActionBar?.hide()
        showRecyclerGrid()

    }

    fun getListFood(): ArrayList<Foods> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataAddress = resources.getStringArray(R.array.data_address)
        val dataKind = resources.getStringArray(R.array.data_kind)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPrice = resources.getStringArray(R.array.data_price)

        val listFood = ArrayList<Foods>()
        for (position in dataName.indices) {
            val food = Foods(
                dataName[position],
                dataAddress[position],
                dataKind[position],
                dataDesc[position],
                dataPrice[position],
                dataPhoto.getResourceId(position, -1)
            )
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerGrid() {
        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        rv_all_popular.layoutManager = layoutManagerStaggered
        rv_all_popular.adapter = StaggeredAdapter(listFood)
    }
}
