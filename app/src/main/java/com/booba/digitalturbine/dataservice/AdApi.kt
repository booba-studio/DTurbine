package com.booba.digitalturbine.dataservice

import com.booba.digitalturbine.model.Json4Kotlin_Base
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
interface AdsServiceApi {
    @GET("getAds")
    suspend fun getAds(@Header("Accept") accept: String="application/json",
        @Query("id") id: Int=236,
        @Query("password") password: String="OVUJ1DJN",
        @Query("siteId") siteId: Int=10777,
        @Query("deviceId") deviceId: Int=4230,
        @Query("sessionId") techtestsession: String="techtestsession",
        @Query("totalCampaignsRequested") totalCampaignsRequested: Int=10,
        @Query("lname") lname: String="Wang"
    ): Response<Json4Kotlin_Base>
}