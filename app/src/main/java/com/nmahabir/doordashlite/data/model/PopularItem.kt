package com.nmahabir.doordashlite.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PopularItem {

    @SerializedName("price")
    @Expose
    var price: Int? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("img_url")
    @Expose
    var imgUrl: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}