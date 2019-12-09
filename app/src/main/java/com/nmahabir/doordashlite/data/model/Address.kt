package com.nmahabir.doordashlite.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {

    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("street")
    @Expose
    var street: String? = null
    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lng")
    @Expose
    var lng: Double? = null
    @SerializedName("printable_address")
    @Expose
    var printableAddress: String? = null

}