# 🏃[Android] GridView demo

## ✏️ Study

- https://yotdark.tistory.com/48
- [[Android] 안드로이드 그리드 뷰(GridView) 사용하기 (1)](https://github.com/Junnnnnnnnnnn/android_study/blob/master/List_gridView/%5BAndroid%5D%20%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C%20%EA%B7%B8%EB%A6%AC%EB%93%9C%20%EB%B7%B0(GridView)%20%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0%20(1).md)
- [[Android] 안드로이드 그리드 뷰(GridView) 사용하기 (2)](https://github.com/Junnnnnnnnnnn/android_study/blob/master/List_gridView/%5BAndroid%5D%20%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C%20%EA%B7%B8%EB%A6%AC%EB%93%9C%20%EB%B7%B0(GridView)%20%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0%20(2).md)

## 🌍 Setting

- CompileSdk = 30
- Minsdk = 24
- TargetSdk = 30

## 🤨 Why

- 이미지를 html 테이블 형식으로 로우와 컬럼으로 뷰잉 하기 위해 사용

## 🙋 Try 

- 이미지 1:1 비율로 뷰잉 하기
- gridView item 을 단일 엘리먼트가 아닌 layout으로 구성 하기
- gridView item click event 처리하기

## ✏️ activity_main 구성하기

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



## ✏️ grid_main 구성하기

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
        android:text="좋아요"
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
        android:text="공유"
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
        android:text="둘러보기"
        android:textColor="@color/black"
        android:textSize="15sp"
        app:layout_constraintBottom_toBottomOf="@id/bottom_view"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/share_text"
        app:layout_constraintTop_toTopOf="@id/bottom_view" />

</androidx.constraintlayout.widget.ConstraintLayout>
```



## ✏️ GridView Adapter Class 구성하기

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
      Toast.makeText(context,"${infoList[position]["id"]}번 좋아요!",Toast.LENGTH_SHORT).show()
    }

    return view!!
  }
}
```



### 뷰홀더 사용하여 이미지 뷰잉 하기

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
    Toast.makeText(context,"${infoList[position]["id"]}번 좋아요!",Toast.LENGTH_SHORT).show()
  }

  return view!!
}

```



### 단일 엘리먼트가 아닌 Inflater 사용하여 layout convert 해보기

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



### 엘리먼트 클릭 이벤트 처리 해 보기

```kotlin
gridViewHolder.like.setOnClickListener{
  Toast.makeText(context,"${infoList[position]["id"]}번 좋아요!",Toast.LENGTH_SHORT).show()
}
```



## ✏️ MainActivity 구성하기

### Gridview adapter 설정 하기

- MainActivity

```kotlin
private fun mainInitGridView(){
  gridView.apply {
    adapter = GridAdapter(this@MainActivity, infoList)
  }
}
```

