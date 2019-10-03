package com.matteopasotti.magicmotion

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.matteopasotti.magicmotion.swipe.SwipeModel
import com.matteopasotti.magicmotion.swipe.SwipeViewModel
import kotlinx.android.synthetic.main.motion_swipe_cards.*

class ExampleActivity : AppCompatActivity() {

    private lateinit var container: View

    private var viewModel : SwipeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = intent.getIntExtra("layout_file_id", R.layout.motion_01_basic)
        setContentView(layout)

        container = findViewById(R.id.motionLayout)

        val debugMode = if (intent.getBooleanExtra("showPaths", false)) {
            MotionLayout.DEBUG_SHOW_PATH
        } else {
            MotionLayout.DEBUG_SHOW_NONE
        }
        (container as? MotionLayout)?.setDebugMode(debugMode)

        if(resources.getResourceEntryName(layout)?.equals("motion_swipe_cards")!!) {
            val viewModel = ViewModelProviders
                .of(this)
                .get(SwipeViewModel::class.java)

            viewModel
                .modelStream
                .observe(this, Observer {
                    bindCard(it)
                })

            motionLayout.setTransitionListener(object : TransitionAdapter() {

                override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                    when (currentId) {
                        R.id.passOffScreen,
                        R.id.likeOffScreen -> {
                            motionLayout.progress = 0f
                            motionLayout.setTransition(R.id.rest, R.id.like)
                            viewModel.swipe()
                        }
                    }
                }

            })
        }
    }

    fun changeState(v: View?) {
        val motionLayout = container as? MotionLayout ?: return
        if (motionLayout.progress > 0.5f) {
            motionLayout.transitionToStart()
        } else {
            motionLayout.transitionToEnd()
        }
    }

    private fun bindCard(model : SwipeModel) {
        topCard.background = getDrawable(model.top.image)
        bottomCard.background = getDrawable(model.bottom.image)
    }
}