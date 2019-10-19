package com.matteopasotti.magicmotion.gallery.model

object Cart {

    var shoeslist = mutableListOf<String>()

    fun addItem(url: String) {
        shoeslist.add(url)
    }
}