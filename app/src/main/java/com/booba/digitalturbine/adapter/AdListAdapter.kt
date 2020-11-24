package com.booba.digitalturbine.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.booba.digitalturbine.R
import com.booba.digitalturbine.databinding.AdListItemBinding
import com.booba.digitalturbine.model.Campaigns
import com.booba.digitalturbine.ui.CompaignActivity
import com.bumptech.glide.Glide

class AdListAdapter(val adList: List<Campaigns>) :
    RecyclerView.Adapter<AdListAdapter.AdViewHolder>() {

    class AdViewHolder(val adItemView: AdListItemBinding) :
        RecyclerView.ViewHolder(adItemView.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdViewHolder {
        val view = DataBindingUtil.inflate<AdListItemBinding>(
            LayoutInflater.from(parent.context), R.layout.ad_list_item,
            parent, false
        )

        return AdViewHolder(view)
    }

    override fun getItemCount(): Int {
        return adList.size
    }

    override fun onBindViewHolder(holder: AdViewHolder, position: Int) {
        holder.adItemView.ad = adList[position]

        Glide.with(holder.itemView.context)
            .load(adList[position].productThumbnail)
            .placeholder(R.drawable.loading)
            .into(holder.adItemView.ivThumnail)


        holder.adItemView.ivThumnail.apply {
            setOnClickListener {
                context.startActivity(Intent(context, CompaignActivity::class.java ).putExtra("campaign", adList[position]))
            }
        }
    }
}