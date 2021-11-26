package com.yotdark.example_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    val gridView: GridView by lazy {
        findViewById(R.id.bottom)
    }

    val infoList = mutableListOf<HashMap<String, Any>>().apply {
        add(hashMapOf("id" to 1, "goods" to "삼양a", "image" to R.drawable.image1))
        add(hashMapOf("id" to 2, "goods" to "삼양b", "image" to R.drawable.image2))
        add(hashMapOf("id" to 3, "goods" to "삼양c", "image" to R.drawable.image3))
        add(hashMapOf("id" to 4, "goods" to "삼양d", "image" to R.drawable.image4))
        add(hashMapOf("id" to 5, "goods" to "삼양e", "image" to R.drawable.image5))
        add(hashMapOf("id" to 6, "goods" to "삼양f", "image" to R.drawable.image6))
        add(hashMapOf("id" to 7, "goods" to "삼양g", "image" to R.drawable.image1))
        add(hashMapOf("id" to 8, "goods" to "삼양h", "image" to R.drawable.image2))
        add(hashMapOf("id" to 9, "goods" to "삼양i", "image" to R.drawable.image3))
        add(hashMapOf("id" to 10, "goods" to "삼양j", "image" to R.drawable.image4))
        add(hashMapOf("id" to 11, "goods" to "삼양k", "image" to R.drawable.image5))
        add(hashMapOf("id" to 12, "goods" to "삼양l", "image" to R.drawable.image6))
        add(hashMapOf("id" to 13, "goods" to "삼양m", "image" to R.drawable.image1))
        add(hashMapOf("id" to 14, "goods" to "삼양n", "image" to R.drawable.image2))
        add(hashMapOf("id" to 15, "goods" to "삼양o", "image" to R.drawable.image3))
        add(hashMapOf("id" to 16, "goods" to "삼양p", "image" to R.drawable.image4))
        add(hashMapOf("id" to 17, "goods" to "삼양q", "image" to R.drawable.image5))
        add(hashMapOf("id" to 18, "goods" to "삼양r", "image" to R.drawable.image6))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainInitGridView()
    }

    private fun mainInitGridView(){
        gridView.apply {
            adapter = GridAdapter(this@MainActivity, infoList)
        }
    }
}