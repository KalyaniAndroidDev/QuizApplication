package com.example.quizapplication.viewmodellivedata.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.quizapplication.R
import com.example.quizapplication.databinding.FragmentTitleGuessWordBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleGuessWordFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleGuessWordFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentTitleGuessWordBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title_guess_word, container, false)

        binding.playGameButton.setOnClickListener {
            findNavController().navigate(TitleGuessWordFragmentDirections.actionTitleToGame())
        }
        return binding.root
    }
}