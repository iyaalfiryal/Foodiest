package com.veronica.idn.foodiest.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import com.veronica.idn.foodiest.activity.DetailPopularFoodActivity
import com.veronica.idn.foodiest.activity.AllPopulerActivity
import com.veronica.idn.foodiest.model.Foods
import com.veronica.idn.foodiest.adapter.PopularFoodAdapter
import com.veronica.idn.foodiest.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val foodList = ArrayList<Foods>()
    private lateinit var popularFoodAdapter: PopularFoodAdapter


    companion object {
        fun defaultFragment(): HomeFragment {
            val home_fragment = HomeFragment()
            val bundle = Bundle()
            home_fragment.arguments = bundle
            return home_fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    val imageContentSlider = intArrayOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5
    )

    val imageContentListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(imageContentSlider[position])

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imageContentListener)
        carouselView.setPageCount(imageContentSlider.count())


        showRecyclerList()

        tv_see_all.setOnClickListener {
            val intent = Intent(context, AllPopulerActivity::class.java)
            startActivity(intent)
        }


    }

    private fun showSelected(it: Foods) {
        val page = Intent(context, DetailPopularFoodActivity::class.java)
        page.putExtra(DetailPopularFoodActivity.KEY_POPULAR_FOOD, it)
        startActivity(page)

    }

    fun getListFood(): ArrayList<Foods> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataAddress = resources.getStringArray(R.array.data_address)
        val dataKind = resources.getStringArray(R.array.data_kind)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listFood = ArrayList<Foods>()
        for (position in dataName.indices) {
            val food = Foods(
                dataName[position],
                dataAddress[position],
                dataKind[position],
                dataPhoto.getResourceId(position, -1)
            )
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerList() {
        popularFoodAdapter = PopularFoodAdapter { showSelected(it) }
        popularFoodAdapter.notifyDataSetChanged()
        popularFoodAdapter.setData(getListFood())
        rv_popular.setHasFixedSize(true)
        rv_popular.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_popular.adapter = popularFoodAdapter

    }
}


