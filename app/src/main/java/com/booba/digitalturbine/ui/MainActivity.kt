package com.booba.digitalturbine.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booba.digitalturbine.R
import com.booba.digitalturbine.adapter.AdListAdapter
import com.booba.digitalturbine.model.Campaigns
import com.booba.digitalturbine.viewmodel.AdViewModel

class MainActivity : AppCompatActivity() {
    lateinit var adListLive: MutableLiveData<List<Campaigns>>

    lateinit var viewModel: AdViewModel
    lateinit var adListAdapter: AdListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = AdViewModel(application)
        setObserver()
    }

    fun setObserver() {
        viewModel.adsListLive.observe(this, Observer {
            adListLive = MutableLiveData()

            adListLive.value = it
            fillRecyclerView()
        })
    }

    fun fillRecyclerView() {

        val recyclerView = findViewById<RecyclerView>(R.id.rvAdList)
        adListAdapter = AdListAdapter(adListLive.value!!)
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adListAdapter
            adListAdapter.notifyDataSetChanged()
        }


    }

}