# ๐[Android] GridView demo

## โ๏ธ Study

- https://yotdark.tistory.com/48
- [[Android] ์๋๋ก์ด๋ ๊ทธ๋ฆฌ๋ ๋ทฐ(GridView) ์ฌ์ฉํ๊ธฐ (1)](https://github.com/Junnnnnnnnnnn/android_study/blob/master/List_gridView/%5BAndroid%5D%20%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C%20%EA%B7%B8%EB%A6%AC%EB%93%9C%20%EB%B7%B0(GridView)%20%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0%20(1).md)
- [[Android] ์๋๋ก์ด๋ ๊ทธ๋ฆฌ๋ ๋ทฐ(GridView) ์ฌ์ฉํ๊ธฐ (2)](https://github.com/Junnnnnnnnnnn/android_study/blob/master/List_gridView/%5BAndroid%5D%20%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C%20%EA%B7%B8%EB%A6%AC%EB%93%9C%20%EB%B7%B0(GridView)%20%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0%20(2).md)

## ๐ Setting

- CompileSdk = 30
- Minsdk = 24
- TargetSdk = 30

## ๐คจ Why

- ์ด๋ฏธ์ง๋ฅผ html ํ์ด๋ธ ํ์์ผ๋ก ๋ก์ฐ์ ์ปฌ๋ผ์ผ๋ก ๋ทฐ์ ํ๊ธฐ ์ํด ์ฌ์ฉ

## ๐ Try 

- ์ด๋ฏธ์ง 1:1 ๋น์จ๋ก ๋ทฐ์ ํ๊ธฐ
- gridView item ์ ๋จ์ผ ์๋ฆฌ๋จผํธ๊ฐ ์๋ layout์ผ๋ก ๊ตฌ์ฑ ํ๊ธฐ
- gridView item click event ์ฒ๋ฆฌํ๊ธฐ

## โ๏ธ activity_main ๊ตฌ์ฑํ๊ธฐ

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/top"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Yoterest"
        android:textColor="#333"
        android:textSize="50sp"
        android:textStyle="normal"
        app:layout_constraintBottom_toTopOf="@+id/bottom"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_chainStyle="packed" />

    <GridView
        android:id="@+id/bottom"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:clipChildren="false"
        android:clipToPadding="false"
        android:horizontalSpacing="2dp"
        android:numColumns="2"
        android:verticalSpacing="2dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/top" />


</androidx.constraintlayout.widget.ConstraintLayout>
```



## โ๏ธ grid_main ๊ตฌ์ฑํ๊ธฐ

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/main_view"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:background="#333"
        android:scaleType="centerCrop"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintDimensionRatio="1:1"
        app:layout_constraintBottom_toBottomOf="parent"/>

    <View
        android:id="@+id/bottom_view"
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:background="#36000000"
        app:layout_constraintBottom_toBottomOf="@id/main_view"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

    <TextView
        android:id="@+id/like_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="20dp"
        android:text="์ข์์"
        android:textColor="@color/black"
        android:textSize="15sp"
        app:layout_constraintBottom_toBottomOf="@id/bottom_view"
        app:layout_constraintEnd_toStartOf="@id/share_text"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@id/bottom_view" />

    <TextView
        android:id="@+id/share_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="20dp"
        android:text="๊ณต์?"
        android:textColor="@color/black"
        android:textSize="15sp"
        app:layout_constraintBottom_toBottomOf="@id/bottom_view"
        app:layout_constraintEnd_toStartOf="@id/go_text"
        app:layout_constraintStart_toEndOf="@id/like_text"
        app:layout_constraintTop_toTopOf="@id/bottom_view" />

    <TextView
        android:id="@+id/go_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="20dp"
        android:text="๋๋ฌ๋ณด๊ธฐ"
        android:textColor="@color/black"
        android:textSize="15sp"
        app:layout_constraintBottom_toBottomOf="@id/bottom_view"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/share_text"
        app:layout_constraintTop_toTopOf="@id/bottom_view" />

</androidx.constraintlayout.widget.ConstraintLayout>
```



## โ๏ธ GridView Adapter Class ๊ตฌ์ฑํ๊ธฐ

- GridAdapter.kt

```kotlin
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
      Toast.makeText(context,"${infoList[position]["id"]}๋ฒ ์ข์์!",Toast.LENGTH_SHORT).show()
    }

    return view!!
  }
}
```



### ๋ทฐํ๋ ์ฌ์ฉํ์ฌ ์ด๋ฏธ์ง ๋ทฐ์ ํ๊ธฐ

```kotlin
inner class GridViewHolder(){
  lateinit var imageView: ImageView
  lateinit var like: TextView
}
@SuppressLint("ViewHolder")
override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

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

  gridViewHolder.like.setOnClickListener{
    Toast.makeText(context,"${infoList[position]["id"]}๋ฒ ์ข์์!",Toast.LENGTH_SHORT).show()
  }

  return view!!
}

```



### ๋จ์ผ ์๋ฆฌ๋จผํธ๊ฐ ์๋ Inflater ์ฌ์ฉํ์ฌ layout convert ํด๋ณด๊ธฐ

```kotlin
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
```



### ์๋ฆฌ๋จผํธ ํด๋ฆญ ์ด๋ฒคํธ ์ฒ๋ฆฌ ํด ๋ณด๊ธฐ

```kotlin
gridViewHolder.like.setOnClickListener{
  Toast.makeText(context,"${infoList[position]["id"]}๋ฒ ์ข์์!",Toast.LENGTH_SHORT).show()
}
```



## โ๏ธ MainActivity ๊ตฌ์ฑํ๊ธฐ

### Gridview adapter ์ค์? ํ๊ธฐ

- MainActivity

```kotlin
private fun mainInitGridView(){
  gridView.apply {
    adapter = GridAdapter(this@MainActivity, infoList)
  }
}
```

