package com.nmahabir.doordashlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.nmahabir.doordashlite.adapters.RestaurantsAdapter
import com.nmahabir.doordashlite.data.model.Restaurant
import com.nmahabir.doordashlite.data.remote.ApiUtils
import com.nmahabir.doordashlite.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private val KEY_RESTAURANT_COUNT = "key_restaurant_count"
    private val KEY_RESTAURANTS = "key_restaurants"
    private lateinit var mAdapter: RestaurantsAdapter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mActivityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mRecyclerView = mActivityMainBinding.restaurantsView

        val restaurantData = ArrayList<Restaurant>()

        if (savedInstanceState != null) {
            val savedItems = savedInstanceState.getInt(KEY_RESTAURANT_COUNT, 0)
            for (i in 0 until savedItems) {
                val item = savedInstanceState.getParcelable<Restaurant>(KEY_RESTAURANTS + i.toString())
                if (item != null) {
                    restaurantData.add(item)
                }
            }
        } else {
            fetchRestaurants()
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

    private fun fetchRestaurants() {
        val call: Call<List<Restaurant>> = ApiUtils.getBackendService().getRestaurants()

        call.enqueue( object : Callback<List<Restaurant>> {
            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error on fetch, message: ${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Error code ${response.code()} on fetch", Toast.LENGTH_SHORT).show()
                }

                if(!response.body().isNullOrEmpty()) {
                    mAdapter.setRestaurants(response.body()!!)
                }
            }

        })
    }
}
