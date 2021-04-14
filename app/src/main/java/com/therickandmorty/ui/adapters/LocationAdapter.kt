package com.therickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.therickandmorty.R
import com.therickandmorty.data.model.LocationResult
import com.therickandmorty.helper.OnItemClickListener
import kotlinx.android.synthetic.main.item_location.view.*

class LocationAdapter(
    private val items: List<LocationResult>?,
    private val onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<LocationAdapter.LocationViewHolder> (){

    inner class LocationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(
            locationResult: LocationResult,
            onItemClickListener: OnItemClickListener
        ) {

            itemView.location_name.text = locationResult.name
            itemView.location_type.text = locationResult.type
            itemView.location_dimension.text = locationResult.dimension

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(locationResult)
            }



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_location, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(items!![position],onItemClickListener)
    }

    override fun getItemCount(): Int {
        return items?.size!!
    }
}