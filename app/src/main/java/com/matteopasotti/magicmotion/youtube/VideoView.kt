package com.matteopasotti.magicmotion.youtube

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class VideoView(context: Context, attributeSet: AttributeSet? = null) : AppCompatImageView(context, attributeSet) {

    fun setEndPadding(value: Float) {
        setPadding(0, 0, value.toInt(), 0)
    }
}