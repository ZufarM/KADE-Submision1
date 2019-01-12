package com.zufar.submision1

import android.content.res.TypedArray
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var image: String = ""
    private var name: String = ""
    private var overview: String = ""

    lateinit var imageView: ImageView
    lateinit var nameTextView: TextView
    lateinit var overviewTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            imageView = imageView()

            nameTextView = textView{
                padding = dip(16)
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                textSize = 18f
            }

            overviewTextView = textView{
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        }

        val intent = intent
        image = intent.getStringExtra("image")
        name = intent.getStringExtra("name")
        overview = intent.getStringExtra("overview")

        Picasso.get().load(image).into(imageView)
        nameTextView.text = name
        overviewTextView.text = overview

    }
}
