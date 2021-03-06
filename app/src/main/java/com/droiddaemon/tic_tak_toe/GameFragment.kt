package com.droiddaemon.tic_tak_toe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.game_fragment, container, false)
    }



}