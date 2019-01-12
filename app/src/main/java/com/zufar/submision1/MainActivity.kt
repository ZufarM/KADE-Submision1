package com.zufar.submision1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.zufar.submision1.R.array.*
import com.zufar.submision1.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
            startActivity<DetailActivity>(
                    "name" to "${it.name}",
                    "overview" to "${it.overview}",
                    "image" to "${it.image}"
            )
        }
    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val overview = resources.getStringArray(club_overview)
        val image = resources.obtainTypedArray(club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(
                    name[i],
                    image.getResourceId(i, 0),
                    overview[i]
            ))
        }

        image.recycle()
    }
}
