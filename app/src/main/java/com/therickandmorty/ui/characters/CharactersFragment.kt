package com.therickandmorty.ui.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.therickandmorty.R
import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.InjectorObject
import com.therickandmorty.data.model.Character
import com.therickandmorty.helper.OnItemClickListener
import com.therickandmorty.ui.adapters.CharactersAdapter
import kotlinx.android.synthetic.main.fragment_characters.*


class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModels {
        InjectorObject.getMainViewModelFactory()
    }

    private lateinit var charactersAdapter: CharactersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charactersViewModel.character.observe(viewLifecycleOwner) {
            when (it) {
//                is ApiResult.Success -> getString(R.string.int_c, it.data.main.temp.toInt())
                is ApiResult.Success -> initList(it.data.results)
                is ApiResult.Error -> it.throwable.message.toString()
                is ApiResult.Loading -> "Loading..."
            }


        }

    }

    private fun initList(charactersList:List<Character>) {

        charactersAdapter = CharactersAdapter(charactersList, object :
            OnItemClickListener {
            override fun <T> onItemClick(listItem: T) {

            }

        })

        val layoutManager = LinearLayoutManager(activity)
        recycler_character.layoutManager = layoutManager
        charactersAdapter.notifyDataSetChanged()
        recycler_character.adapter = charactersAdapter

    }
}