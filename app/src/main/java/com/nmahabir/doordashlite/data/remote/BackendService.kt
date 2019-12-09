package com.nmahabir.doordashlite.data.remote

import com.nmahabir.doordashlite.data.model.RestaurantsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BackendService {
    @GET("/restaurant/?lat=37.422740&lng=-122.139956")
    fun getRestaurants(): Call<RestaurantsResponse>

    @GET("/restaurant/")
    fun getRestaurants(@Query("lat") lat: Double, @Query("lng") lng:Double): Call<RestaurantsResponse>
}