package com.nmahabir.doordashlite.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Restaurant() : Parcelable {

    @SerializedName("is_time_surging")
    @Expose
    var isTimeSurging: Boolean? = null
    @SerializedName("max_order_size")
    @Expose
    var maxOrderSize: Int? = null
    @SerializedName("delivery_fee")
    @Expose
    var deliveryFee: Int? = null
    @SerializedName("max_composite_score")
    @Expose
    var maxCompositeScore: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("merchant_promotions")
    @Expose
    var merchantPromotions: List<MerchantPromotion>? = null
    @SerializedName("average_rating")
    @Expose
    var averageRating: Double? = null
    @SerializedName("menus")
    @Expose
    var menus: List<Menu>? = null
    @SerializedName("composite_score")
    @Expose
    var compositeScore: Int? = null
    @SerializedName("status_type")
    @Expose
    var statusType: String? = null
    @SerializedName("is_only_catering")
    @Expose
    var isOnlyCatering: Boolean? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("number_of_ratings")
    @Expose
    var numberOfRatings: Int? = null
    @SerializedName("asap_time")
    @Expose
    var asapTime: Int? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("business")
    @Expose
    var business: Business? = null
    @SerializedName("tags")
    @Expose
    var tags: List<String>? = null
    @SerializedName("yelp_review_count")
    @Expose
    var yelpReviewCount: Int? = null
    @SerializedName("business_id")
    @Expose
    var businessId: Int? = null
    @SerializedName("extra_sos_delivery_fee")
    @Expose
    var extraSosDeliveryFee: Int? = null
    @SerializedName("yelp_rating")
    @Expose
    var yelpRating: Double? = null
    @SerializedName("cover_img_url")
    @Expose
    var coverImgUrl: String? = null
    @SerializedName("header_img_url")
    @Expose
    var headerImgUrl: String? = null
    @SerializedName("address")
    @Expose
    var address: Address? = null
    @SerializedName("price_range")
    @Expose
    var priceRange: Int? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("is_newly_added")
    @Expose
    var isNewlyAdded: Boolean? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("service_rate")
    @Expose
    var serviceRate: Double? = null
    @SerializedName("promotion")
    @Expose
    var promotion: Any? = null
    @SerializedName("featured_category_description")
    @Expose
    var featuredCategoryDescription: Any? = null

    constructor(parcel: Parcel) : this() {
        isTimeSurging = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        maxOrderSize = parcel.readValue(Int::class.java.classLoader) as? Int
        deliveryFee = parcel.readValue(Int::class.java.classLoader) as? Int
        maxCompositeScore = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        averageRating = parcel.readValue(Double::class.java.classLoader) as? Double
        compositeScore = parcel.readValue(Int::class.java.classLoader) as? Int
        statusType = parcel.readString()
        isOnlyCatering = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        status = parcel.readString()
        numberOfRatings = parcel.readValue(Int::class.java.classLoader) as? Int
        asapTime = parcel.readValue(Int::class.java.classLoader) as? Int
        description = parcel.readString()
        tags = parcel.createStringArrayList()
        yelpReviewCount = parcel.readValue(Int::class.java.classLoader) as? Int
        businessId = parcel.readValue(Int::class.java.classLoader) as? Int
        extraSosDeliveryFee = parcel.readValue(Int::class.java.classLoader) as? Int
        yelpRating = parcel.readValue(Double::class.java.classLoader) as? Double
        coverImgUrl = parcel.readString()
        headerImgUrl = parcel.readString()
        priceRange = parcel.readValue(Int::class.java.classLoader) as? Int
        slug = parcel.readString()
        name = parcel.readString()
        isNewlyAdded = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        url = parcel.readString()
        serviceRate = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(isTimeSurging)
        parcel.writeValue(maxOrderSize)
        parcel.writeValue(deliveryFee)
        parcel.writeValue(maxCompositeScore)
        parcel.writeValue(id)
        parcel.writeValue(averageRating)
        parcel.writeValue(compositeScore)
        parcel.writeString(statusType)
        parcel.writeValue(isOnlyCatering)
        parcel.writeString(status)
        parcel.writeValue(numberOfRatings)
        parcel.writeValue(asapTime)
        parcel.writeString(description)
        parcel.writeStringList(tags)
        parcel.writeValue(yelpReviewCount)
        parcel.writeValue(businessId)
        parcel.writeValue(extraSosDeliveryFee)
        parcel.writeValue(yelpRating)
        parcel.writeString(coverImgUrl)
        parcel.writeString(headerImgUrl)
        parcel.writeValue(priceRange)
        parcel.writeString(slug)
        parcel.writeString(name)
        parcel.writeValue(isNewlyAdded)
        parcel.writeString(url)
        parcel.writeValue(serviceRate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Restaurant> {
        override fun createFromParcel(parcel: Parcel): Restaurant {
            return Restaurant(parcel)
        }

        override fun newArray(size: Int): Array<Restaurant?> {
            return arrayOfNulls(size)
        }
    }
}