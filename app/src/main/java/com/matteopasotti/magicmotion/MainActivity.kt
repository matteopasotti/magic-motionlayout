package com.matteopasotti.magicmotion

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matteopasotti.magicmotion.adapter.ExampleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var doShowPaths = false

    private val dataset: Array<ExampleAdapter.Example> = arrayOf(
        ExampleAdapter.Example("Basic Example (1/3)", R.layout.motion_01_basic),
        ExampleAdapter.Example("Basic Example (2/3)", R.layout.motion_02_basic),
        ExampleAdapter.Example("Basic Example (3/3)", R.layout.motion_03_basic),
        ExampleAdapter.Example("CoordinatorLayout (1/2)", R.layout.motion_01_coordinator),
        ExampleAdapter.Example("CoordinatorLayout (2/2)", R.layout.motion_02_coordinator),
        ExampleAdapter.Example("Program", R.layout.motion_programmatic),
        ExampleAdapter.Example("Tinder Match", R.layout.motion_tinder_match),
        ExampleAdapter.Example("Tinder Swipe", R.layout.motion_swipe_cards)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = ExampleAdapter(dataset)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        showPaths.setOnCheckedChangeListener(this)
    }

    fun start(activity: Class<*>, layoutFileId: Int) {
        val intent = Intent(this, activity).apply {
            putExtra("layout_file_id", layoutFileId)
            putExtra("showPaths", doShowPaths)
        }
        startActivity(intent)
    }

    override fun onCheckedChanged(p0: CompoundButton?, value: Boolean) {
        doShowPaths = value
    }
}