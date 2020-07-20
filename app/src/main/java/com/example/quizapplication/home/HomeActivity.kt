package com.example.quizapplication.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.quizapplication.R
import com.example.quizapplication.game.GameActivity
import com.example.quizapplication.gamewithnavigation.GameWithNavigationActivity
import com.example.quizapplication.lifecycleexample.LifeCycleActivity
import com.example.quizapplication.viewmodellivedata.GuessWordMainActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.btn_game_with_traditional).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        })
        findViewById<Button>(R.id.btn_game_with_navigation).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, GameWithNavigationActivity::class.java))
        })
        findViewById<Button>(R.id.btn_lifecycle_library).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, LifeCycleActivity::class.java))
        })
        findViewById<Button>(R.id.btn_view_model_live_data).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, GuessWordMainActivity::class.java))
        })
    }
}