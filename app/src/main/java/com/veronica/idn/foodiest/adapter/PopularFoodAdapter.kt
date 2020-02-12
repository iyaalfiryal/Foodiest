package com.veronica.idn.foodiest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.veronica.idn.foodiest.R
import com.veronica.idn.foodiest.model.Foods
import kotlinx.android.synthetic.main.item_row.view.*

class PopularFoodAdapter(private val listener: (Foods) -> Unit) :
    RecyclerView.Adapter<PopularFoodAdapter.PopularViewHolder>() {

    private val listFoods = ArrayList<Foods>()

    fun setData(items: ArrayList<Foods>) {
        listFoods.clear()
        listFoods.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int = listFoods.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(listFoods[position], listener)
    }

    class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(foods: Foods, listener: (Foods) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context).load(foods.images)
                    .apply(RequestOptions().override(100))
                    .into(iv_popular)

                tv_name_restaurant.setText(foods.name)
                tv_address.setText(foods.address)
                tv_kind.setText(foods.kind)

                itemView.setOnClickListener { listener(foods) }

            }
        }

    }
}