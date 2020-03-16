package com.nmahabir.doordashlite.data.remote

import com.nmahabir.doordashlite.data.model.Restaurant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface BackendService {
    @GET("restaurant/?lat=37.422740&lng=-122.139956&offset=0&limit=50")
    fun getRestaurants(): Call<List<Restaurant>>

    @GET("restaurant/")
    fun getRestaurants(@Query("lat") lat: Double, @Query("lng") lng:Double): Observable<List<Restaurant>>
}