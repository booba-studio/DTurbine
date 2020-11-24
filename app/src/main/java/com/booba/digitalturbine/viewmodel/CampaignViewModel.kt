package com.booba.digitalturbine.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.booba.digitalturbine.R
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class CampaignViewModel(private val application: Application): ViewModel() {

    fun loadData( url: String, view: ImageView) {
        viewModelScope.launch {
                Glide.with(application)
                    .load(url)
                    .placeholder(R.drawable.loading)
                    .into(view)
        }
    }
}
