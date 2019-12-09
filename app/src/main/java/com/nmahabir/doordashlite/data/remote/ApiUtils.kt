package com.nmahabir.doordashlite.data.remote

class ApiUtils {
    val BASE_URL = "https://api.doordash.com/v2"

    fun getBackendService(): BackendService {
        return RetrofitClient.getClient(BASE_URL).create(BackendService::class.java)
    }
}