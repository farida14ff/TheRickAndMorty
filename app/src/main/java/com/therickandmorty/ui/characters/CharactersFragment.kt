package com.therickandmorty.ui.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.therickandmorty.R
import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.InjectorObject


class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModels {
        InjectorObject.getMainViewModelFactory()
    }


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
            val text = when (it) {
//                is ApiResult.Success -> getString(R.string.int_c, it.data.main.temp.toInt())
                is ApiResult.Success -> "Success"
                is ApiResult.Error -> it.throwable.message.toString()
                is ApiResult.Loading -> "Loading..."
            }

//            tv_whether.text = text

        }



    }
}