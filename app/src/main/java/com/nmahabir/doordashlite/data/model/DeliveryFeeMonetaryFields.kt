package com.nmahabir.doordashlite.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DeliveryFeeMonetaryFields {

    @SerializedName("currency")
    @Expose
    var currency: String? = null
    @SerializedName("display_string")
    @Expose
    var displayString: String? = null
    @SerializedName("unit_amount")
    @Expose
    var unitAmount: Int? = null
    @SerializedName("decimal_places")
    @Expose
    var decimalPlaces: Int? = null

}