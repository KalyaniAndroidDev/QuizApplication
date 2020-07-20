package com.example.quizapplication.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapplication.R

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TitleFragment.newInstance())
                .commitNow()
        }
    }
}