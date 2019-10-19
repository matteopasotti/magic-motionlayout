package com.matteopasotti.magicmotion.youtube

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.fragment.app.Fragment
import com.matteopasotti.magicmotion.R
import kotlinx.android.synthetic.main.activity_youtube.*
import kotlinx.android.synthetic.main.motion_video_fragment.*
import kotlin.math.abs

class VideoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.motion_video_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videoMotionLayout : MotionLayout = videoMotionLayout


        videoMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun allowsTransition(p0: MotionScene.Transition?): Boolean {
                return true
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                val youtubeActivity = activity as YoutubeActivity
                youtubeActivity.mainMotionLayout.progress = abs(p3)
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.e("onTransitionCompleted ", "VideoFragment")
            }
        })
    }
}