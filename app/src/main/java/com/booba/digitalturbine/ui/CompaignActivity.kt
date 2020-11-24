package com.booba.digitalturbine.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.booba.digitalturbine.R
import com.booba.digitalturbine.databinding.ActivityCampainDetailBinding
import com.booba.digitalturbine.model.Campaigns
import com.booba.digitalturbine.viewmodel.CampaignViewModel

class CompaignActivity : AppCompatActivity() {

    lateinit var viewModel: CampaignViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityCampainDetailBinding: ActivityCampainDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_campain_detail)

        viewModel = CampaignViewModel(application)
        val campaign = intent.getParcelableExtra<Campaigns>("campaign")
        Log.d("Campaign viewmodel", "data: ${campaign.toString()}")
        campaign?.apply {
            //viewModel.loadData(productThumbnail!!, activityCampainDetailBinding.productThumbnail)
            productThumbnail?.apply {
                viewModel.loadData(this, activityCampainDetailBinding.productThumbnail)
            }
            /*averageRatingImageURL?.apply {
                viewModel.loadData(this, activityCampainDetailBinding.averageRatingImageURL)
            }*/
            productImage?.apply {
                viewModel.loadData(this, activityCampainDetailBinding.productImage)
            }

        }
        activityCampainDetailBinding.c = campaign
        activityCampainDetailBinding.notifyChange()

    }
}