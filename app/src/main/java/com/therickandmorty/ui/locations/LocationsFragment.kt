package com.therickandmorty.ui.locations

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.therickandmorty.R
import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.InjectorObject
import com.therickandmorty.data.model.LocationResult
import com.therickandmorty.helper.OnItemClickListener
import com.therickandmorty.ui.adapters.LocationAdapter
import kotlinx.android.synthetic.main.fragment_locations.*


class LocationsFragment : Fragment() {

    private val locationViewModel: LocationViewModel by viewModels {
        InjectorObject.getLocationViewHolderFactory()
    }

    private lateinit var locationAdapter: LocationAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_locations, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationViewModel.whether.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success -> {
                    Log.e("Location Success", it.data.toString())
                    initList(it.data.locationResults)
                }
                is ApiResult.Error -> {
                    it.throwable.message.toString()
                    Log.e("Location Error", it.throwable.message.toString())
                }
                is ApiResult.Loading -> "Loading..." //Todo progressbar
            }
        }


    }

    private fun initList(locationsList: List<LocationResult>) {

        locationAdapter = LocationAdapter(locationsList, object :
            OnItemClickListener {
            override fun <T> onItemClick(listItem: T) {

            }

        })

        val layoutManager = LinearLayoutManager(activity)
        recycler_location.layoutManager = layoutManager
        locationAdapter.notifyDataSetChanged()
        recycler_location.adapter = locationAdapter


    }

}