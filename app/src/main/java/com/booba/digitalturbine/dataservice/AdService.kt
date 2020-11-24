package com.booba.digitalturbine.dataservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AdService {
    private val retrofit: Retrofit? = null
    private const val BASE_URL = "http://ads.appia.com/"
    val service: AdsServiceApi
        get() = if (retrofit == null) {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(AdsServiceApi::class.java)
        } else retrofit.create(AdsServiceApi::class.java)
}