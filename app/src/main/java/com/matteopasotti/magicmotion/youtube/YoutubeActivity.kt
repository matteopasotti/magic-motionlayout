package com.matteopasotti.magicmotion.youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matteopasotti.magicmotion.R

class YoutubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_youtube)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, VideoFragment())
                .commit()
        }
    }
}