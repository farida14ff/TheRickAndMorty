package com.therickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.therickandmorty.R
import com.therickandmorty.data.model.Episode
import com.therickandmorty.helper.OnItemClickListener
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodesAdapter(
    private val items: List<Episode>?,
    private val onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder> (){

    inner class EpisodeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(
            episode: Episode,
            onItemClickListener: OnItemClickListener
        ) {

            itemView.episode_id.text = episode.id.toString()
            itemView.episode_name.text = episode.name
            itemView.episode_air_date.text = episode.air_date

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(episode)
            }



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_episode, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(items!![position],onItemClickListener)
    }

    override fun getItemCount(): Int {
        return items?.size!!
    }
}