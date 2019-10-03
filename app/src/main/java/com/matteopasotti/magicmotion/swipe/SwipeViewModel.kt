package com.matteopasotti.magicmotion.swipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matteopasotti.magicmotion.R

class SwipeViewModel : ViewModel() {

    private val stream = MutableLiveData<SwipeModel>()

    val modelStream: LiveData<SwipeModel>
        get() = stream

    private val data = listOf(
        SwipeCardModel(image = R.drawable.woman_profile),
        SwipeCardModel(image = R.drawable.jennifer),
        SwipeCardModel(image = R.drawable.scarlett),
        SwipeCardModel(image = R.drawable.woman_profile)
    )
    private var currentIndex = 0

    private val topCard
        get() = data[currentIndex % data.size]
    private val bottomCard
        get() = data[(currentIndex + 1) % data.size]

    init {
        updateStream()
    }

    fun swipe() {
        currentIndex += 1
        updateStream()
    }

    private fun updateStream() {
        stream.value = SwipeModel(
            top = topCard,
            bottom = bottomCard
        )
    }
}