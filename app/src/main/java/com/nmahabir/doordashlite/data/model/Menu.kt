package com.nmahabir.doordashlite.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Menu {

    @SerializedName("popular_items")
    @Expose
    var popularItems: List<PopularItem>? = null
    @SerializedName("is_catering")
    @Expose
    var isCatering: Boolean? = null
    @SerializedName("subtitle")
    @Expose
    var subtitle: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}