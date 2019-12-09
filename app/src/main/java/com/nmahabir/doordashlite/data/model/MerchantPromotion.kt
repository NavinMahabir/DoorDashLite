package com.nmahabir.doordashlite.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MerchantPromotion {

    @SerializedName("minimum_subtotal_monetary_fields")
    @Expose
    var minimumSubtotalMonetaryFields: MinimumSubtotalMonetaryFields? = null
    @SerializedName("delivery_fee")
    @Expose
    var deliveryFee: Any? = null
    @SerializedName("delivery_fee_monetary_fields")
    @Expose
    var deliveryFeeMonetaryFields: DeliveryFeeMonetaryFields? = null
    @SerializedName("minimum_subtotal")
    @Expose
    var minimumSubtotal: Any? = null
    @SerializedName("new_store_customers_only")
    @Expose
    var newStoreCustomersOnly: Boolean? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null

}