package com.nmahabir.doordashlite.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nmahabir.doordashlite.R
import com.nmahabir.doordashlite.data.model.Restaurant
import com.nmahabir.doordashlite.databinding.ViewRestaurantBinding


data class RestaurantData(
    val title: String,
    val imgCover: String,
    val description: String,
    val status: String
) {
    companion object {
        @JvmStatic
        @BindingAdapter("coverImage")
        fun loadImage(view: ImageView?, imgUrl: String = "") {
            if (view != null) {
                Glide.with(view.context)
                    .load(imgUrl)
                    .centerCrop()
                    .placeholder(R.drawable.doordash_logo)
                    .error(R.drawable.doordash_logo)
                    .into(view)
            }
        }
    }
}

class RestaurantsAdapter(
    private var mRestaurants: List<Restaurant>,
    private var mContext: Context,
    private var mItemListener: RestaurantItemListener

) : RecyclerView.Adapter<RestaurantsAdapter.RestaurantViewHolder>() {

    inner class RestaurantViewHolder(binding: ViewRestaurantBinding, private var mItemListener: RestaurantItemListener) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private var binding: ViewRestaurantBinding? = null

        fun bind(obj: RestaurantData?) {
            binding?.restaurant = obj!!
            binding?.executePendingBindings()
        }

        init {
            this.binding = binding
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val item = getItem(adapterPosition)
            this.mItemListener.onPostClick(item.id!!)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemBinding: ViewRestaurantBinding = ViewRestaurantBinding.inflate(inflater, parent, false)

        return RestaurantViewHolder(itemBinding, mItemListener)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {

        val restaurant = mRestaurants[position]

        val viewData = RestaurantData(
            title = restaurant.name ?: "",
            imgCover = restaurant.coverImgUrl?: "",
            description = restaurant.description ?: "",
            status = restaurant.status ?: "")

        holder.bind(viewData)
    }


    override fun getItemCount(): Int {
        return mRestaurants.size
    }

    private fun getItem(adapterPosition: Int): Restaurant {
        return mRestaurants[adapterPosition]
    }

    interface RestaurantItemListener {
        fun onPostClick(id: Int)
    }

    fun getRestaurants() : List<Restaurant> {
        return mRestaurants
    }

    fun setRestaurants(restaurants: List<Restaurant>) {
        mRestaurants = restaurants
        notifyDataSetChanged()
    }

}