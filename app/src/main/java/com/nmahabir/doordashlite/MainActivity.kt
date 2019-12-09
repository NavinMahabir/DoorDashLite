package com.nmahabir.doordashlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import com.nmahabir.doordashlite.adapters.RestaurantsAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: RestaurantsAdapter
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.restaurants_view)
        mAdapter = RestaurantsAdapter(ArrayList(),this,  object : RestaurantsAdapter.RestaurantItemListener {
            override fun onPostClick(id: Int) {
                Toast.makeText(this@MainActivity, "Post id is$id", Toast.LENGTH_SHORT).show()
            }
        })

        val layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = mAdapter
        mRecyclerView.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        mRecyclerView.addItemDecoration(itemDecoration)
    }
}
