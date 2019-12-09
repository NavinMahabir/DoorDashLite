package com.nmahabir.doordashlite.adapters

import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.nmahabir.doordashlite.R
import com.nmahabir.doordashlite.data.model.Restaurant
import com.nmahabir.doordashlite.data.remote.ApiUtils
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class RestaurantsAdapter(
    private var mRestaurants: List<Restaurant>,
    private var mContext: Context,
    private var mItemListener: RestaurantItemListener

) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, private var mItemListener: RestaurantItemListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var titleTv: TextView = itemView.findViewById(R.id.txtName)
        var coverIv: ImageView = itemView.findViewById(R.id.imgCover)
        var descriptionTv: TextView = itemView.findViewById(R.id.txtDescription)
        var statusTv: TextView = itemView.findViewById(R.id.txtStatus)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val item = getItem(adapterPosition)
            this.mItemListener.onPostClick(item.id!!)

            notifyDataSetChanged()
        }
    }

    init {
        fetchRestaurants()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val postView = inflater.inflate(R.layout.view_restaurant, parent, false)

        return ViewHolder(postView, mItemListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val restaurant = mRestaurants[position]
        holder.titleTv.text = restaurant.name
        holder.statusTv.text = restaurant.status
        holder.descriptionTv.text = restaurant.description

        Glide.with(mContext)
            .load(restaurant.coverImgUrl)
            .centerCrop()
            .placeholder(R.drawable.doordash_logo)
            .error(R.drawable.doordash_logo)
            .into(holder.coverIv)
    }


    override fun getItemCount(): Int {
        return mRestaurants.size
    }

    fun updateRestaurants(restaurants: List<Restaurant>) {
        mRestaurants = restaurants
        notifyDataSetChanged()
    }

    private fun getItem(adapterPosition: Int): Restaurant {
        return mRestaurants[adapterPosition]
    }

    interface RestaurantItemListener {
        fun onPostClick(id: Int)
    }

    private fun fetchRestaurants() {
        ApiUtils.getBackendService().getRestaurants().subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
        )
            .subscribe(object : Subscriber<List<Restaurant>>() {

                override fun onCompleted() {
                }

                override fun onError(e: Throwable) {
                }

                override fun onNext(restaurants: List<Restaurant>) {
                    updateRestaurants(restaurants)
                }
            })
    }

    fun getRestaurants() : List<Restaurant> {
        return mRestaurants
    }
}