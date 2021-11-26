    package com.yotdark.example_gridview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class GridAdapter(private val context: Context, private val infoList: MutableList<HashMap<String, Any>>): BaseAdapter() {

    inner class GridViewHolder(){
        lateinit var imageView: ImageView
        lateinit var like: TextView
    }

    override fun getCount() = infoList.size

    override fun getItem(position: Int) = infoList[position]

    override fun getItemId(position: Int) = position.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        var gridViewHolder = GridViewHolder()

        if(convertView == null){
            view = LayoutInflater
                .from(context)
                .inflate(R.layout.grid_main, parent, false)
            gridViewHolder.imageView = view.findViewById(R.id.main_view)
            gridViewHolder.like = view.findViewById(R.id.like_text)
            view.tag = gridViewHolder
        }else{
            gridViewHolder = view!!.tag as GridViewHolder
        }

        if(position < infoList.size){
            gridViewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, infoList[position]["image"].toString().toInt()))
        }

        gridViewHolder.like.setOnClickListener{
            Toast.makeText(context,"${infoList[position]["id"]}번 좋아요!",Toast.LENGTH_SHORT).show()
        }

        return view!!
    }
}