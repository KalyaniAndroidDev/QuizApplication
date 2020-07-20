package com.example.quizapplication.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quizapplication.R
import com.example.quizapplication.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    private lateinit var bindingGameFragment: FragmentTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingGameFragment = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )
        bindingGameFragment.btnPlay.setOnClickListener(View.OnClickListener {
            val ft = activity?.supportFragmentManager!!.beginTransaction()
            ft.replace(R.id.container, GameFragment(), "NewFragmentTag")
            ft.commit()
        })
        return bindingGameFragment.root
    }

    companion object {
        fun newInstance() = TitleFragment()
    }
}