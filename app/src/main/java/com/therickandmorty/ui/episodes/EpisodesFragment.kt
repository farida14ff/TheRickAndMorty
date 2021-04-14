package com.therickandmorty.ui.episodes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.therickandmorty.R
import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.InjectorObject
import com.therickandmorty.data.model.Episode
import com.therickandmorty.helper.OnItemClickListener
import com.therickandmorty.ui.adapters.EpisodesAdapter
import kotlinx.android.synthetic.main.fragment_episodes.*


class EpisodesFragment : Fragment() {

    private val episodesViewModel: EpisodesViewModel by viewModels {
        InjectorObject.getEpisodeViewModelFactory()
    }

    private lateinit var episodesAdapter: EpisodesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episodes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        episodesViewModel.episode.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success ->{
                    initList(it.data.episodes)
                }
                is ApiResult.Error -> {
                    it.throwable.message.toString()
                    Log.e("Episodes Error", it.throwable.message.toString())

                }
                is ApiResult.Loading -> {
                    Log.e("Episodes hendel", "Loading")
                    "Loading..."
                } //Todo progressbar
            }


        }

    }

    private fun initList(episodesList:List<Episode>) {
        Log.e("Episodes hendel", "in list initer")


        episodesAdapter = EpisodesAdapter(episodesList, object :
            OnItemClickListener {
            override fun <T> onItemClick(listItem: T) {

            }

        })

        val layoutManager = LinearLayoutManager(activity)
        recycler_episode.layoutManager = layoutManager
        episodesAdapter.notifyDataSetChanged()
        recycler_episode.adapter = episodesAdapter

    }
}