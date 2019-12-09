package com.nmahabir.doordashlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import com.nmahabir.doordashlite.adapters.RestaurantsAdapter
import com.nmahabir.doordashlite.data.model.Restaurant
import com.nmahabir.doordashlite.data.remote.ApiUtils


class MainActivity : AppCompatActivity() {
    private val KEY_RESTAURANT_COUNT = "key_restaurant_count"
    private val KEY_RESTAURANTS = "key_restaurants"
    private lateinit var mAdapter: RestaurantsAdapter
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.restaurants_view)

        val restaurantData = ArrayList<Restaurant>()

        if (savedInstanceState != null) {
            val savedItems = savedInstanceState.getInt(KEY_RESTAURANT_COUNT, 0)
            for (i in 0 until savedItems) {
                val item = savedInstanceState.getParcelable<Restaurant>(KEY_RESTAURANTS + i.toString())
                if (item != null) {
                    restaurantData.add(item)
                }
            }
        }

        mAdapter = RestaurantsAdapter(restaurantData,this,  object : RestaurantsAdapter.RestaurantItemListener {
            override fun onPostClick(id: Int) {
                Toast.makeText(this@MainActivity, "Post id is $id", Toast.LENGTH_SHORT).show()
            }
        })

        val layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = mAdapter
        mRecyclerView.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        mRecyclerView.addItemDecoration(itemDecoration)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        var items = mAdapter.getRestaurants()
        savedInstanceState.putInt(KEY_RESTAURANT_COUNT, items.size)
        for (i in items.indices) {
            savedInstanceState.putParcelable(KEY_RESTAURANTS + i.toString(), items[i])
        }
    }
}
