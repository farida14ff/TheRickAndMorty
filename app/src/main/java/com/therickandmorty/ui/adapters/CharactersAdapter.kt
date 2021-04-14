package com.therickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.therickandmorty.R
import com.therickandmorty.helper.OnItemClickListener
import kotlinx.android.synthetic.main.item_character.view.*
import com.therickandmorty.data.model.Character

class CharactersAdapter(
    private val items: List<Character>?,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {



    inner class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(
            character: Character,
            onItemClickListener: OnItemClickListener
        ) {

            itemView.characters_name.text = character.name
            itemView.characters_location.text = character.location.name
            itemView.characters_species.text = character.species
            itemView.characters_status.text = character.status

            Glide.with(itemView).load(character.image).into(itemView.character_image)

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(character)

            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.onBind(items!![position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return items?.size!!

    }


}
