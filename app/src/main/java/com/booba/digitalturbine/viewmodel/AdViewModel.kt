package com.booba.digitalturbine.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.booba.digitalturbine.dataservice.AdService
import com.booba.digitalturbine.model.Campaigns
import kotlinx.coroutines.launch

class AdViewModel(application: Application) : AndroidViewModel(application) {
    var adsListLive = MutableLiveData<List<Campaigns>>()
    lateinit var loadError: MutableLiveData<String>

    init {
        val adService = AdService.service
        viewModelScope.launch {
            val response =  adService.getAds()
            when (response.isSuccessful) {
                true -> {
                    adsListLive.value = response.body()?.campaigns
                }
                false -> onError("Error: ${response.message()}")
            }
        }
    }
    private fun onError(message: String) {
        loadError.value = message
    }

}