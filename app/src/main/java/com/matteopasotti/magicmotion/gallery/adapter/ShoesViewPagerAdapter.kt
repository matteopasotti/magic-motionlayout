package com.matteopasotti.magicmotion.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.matteopasotti.magicmotion.R
import com.matteopasotti.magicmotion.gallery.model.FactoryOutlet

class ShoesViewPagerAdapter (private val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val shoe = FactoryOutlet.makeShoesList().get(position)
        val layout = LayoutInflater.from(context).inflate(R.layout.pager_view, container, false)

        layout.apply {
            findViewById<TextView>(R.id.model_name).text = shoe.name
            findViewById<TextView>(R.id.model_descr).text = shoe.descr
            findViewById<TextView>(R.id.model_price).text = shoe.price
        }

        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return FactoryOutlet.makeShoesList().size
    }
}