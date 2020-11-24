package com.booba.digitalturbine.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.booba.digitalturbine.R
import com.bumptech.glide.Glide
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Json4Kotlin_Base (

    val campaigns : List<Campaigns>?,
    val totalCampaignsRequested : Int?,
    val serverId : String?,
    val responseTime : String?,
    val errorMessage : String?,
    val version : String?
):Parcelable

@Parcelize
data class Campaigns (

    val advertiserDomainUrl : String?,
    val apks : String?,
    val appId : String?,
    val appPrivacyPolicyUrl : String?,
    val averageRatingImageURL : String?,
    val bidRate : Float?,
    val billingTypeId : Int?,
    val callToAction : String?,
    val campaignDisplayOrder : Int?,
    val campaignId : Int?,
    val campaignTypeId : Int?,
    val carrier : String?,
    val categoryName : String?,
    val clickProxyURL : String?,
    val creativeId : Int?,
    val developerName : String?,
    val dtPrivacyPolicyUrl : String?,
    val externalMetadata : String?,
    val googlePlayAppStoreUrl : String?,
    val homeScreen : Boolean?,
    val impressionTrackingURL : String?,
    val isRandomPick : Boolean?,
    val longDescription : String?,
    val maxOSVersion : String?,
    val minOSVersion : String?,
    val mmpPartner : String?,
    val numberOfRatings : String?,
    val productDescription : String?,
    val productId : Int?,
    val productImage : String?,
    val productName : String?,
    val productThumbnail : String?,
    val rating : Float?,
    val numberOfDownloads : String?,
    val tstiEligible : Boolean?,
    val stiEnabled : Boolean?,
    val screenshots : String?,
    val postInstallActions : List<String?>
):Parcelable

class Util {
    companion object {
        @BindingAdapter("imgUrl")
        fun loadImage(imageView: ImageView, imageURL: String?) {
            Glide.with(imageView.context)
                .load(imageURL)
                .placeholder(R.drawable.loading)
                .into(imageView)
        }
    }
}