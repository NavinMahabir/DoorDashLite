package com.nmahabir.doordashlite.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Restaurant {

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
}