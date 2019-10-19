package com.matteopasotti.magicmotion.gallery

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager
import com.matteopasotti.magicmotion.R
import com.matteopasotti.magicmotion.gallery.adapter.ShoesViewPagerAdapter
import com.matteopasotti.magicmotion.gallery.model.Cart
import com.matteopasotti.magicmotion.gallery.model.FactoryOutlet
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.shoe_view.*

class ShoesActivity : AppCompatActivity() {

    private lateinit var container: View

    private lateinit var shoeImage: ImageView

    private val list = FactoryOutlet.makeShoesList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.motion_gallery_shoes)

        container = findViewById(R.id.motionLayout)
        shoeImage = findViewById(R.id.shoe_image)

        val debugMode = if (intent.getBooleanExtra("showPaths", false)) {
            MotionLayout.DEBUG_SHOW_PATH
        } else {
            MotionLayout.DEBUG_SHOW_NONE
        }

        (container as? MotionLayout)?.setDebugMode(debugMode)

        setupPager()
    }


    private fun setupPager() {
        val pager = findViewById<ViewPager>(R.id.pager)
        pager.adapter = ShoesViewPagerAdapter(this)
        setImage(list[0].url)

        pager.addOnPageChangeListener(motionPager as ViewPager.OnPageChangeListener)
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                setImage(list[p0].url)
            }

        })

    }


    private fun setImage(url: String) {
        Picasso.get()
            .load(url)
            .resize(200, 200)
            .centerCrop()
            .into(shoeImage)
    }
}