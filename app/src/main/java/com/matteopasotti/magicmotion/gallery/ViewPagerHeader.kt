package com.matteopasotti.magicmotion.gallery

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager

class ViewPagerHeader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), ViewPager.OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(
        position: Int,
        positionOffset: Float,
        positionOffsetPixels: Int
    ) {
        progress = (position + positionOffset) / 2
        Log.d("ViewPagerHeader" , "ViewPagerHeader progress MotionLayout : $progress")
    }

    override fun onPageSelected(position: Int) {

    }


}