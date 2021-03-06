/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 skydoves
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.skydoves.medaldemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.ArrayList

class RankingActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_rankling)

    val listView = findViewById<ListView>(R.id.listView)

    val items = ArrayList<RankingItem>()
    val adapter = RankingAdapter(this, R.layout.item_rank, items)

    val item0 = RankingItem(
        ContextCompat.getDrawable(this, R.drawable.medal2)!!,
        ContextCompat.getDrawable(this, R.drawable.face1)!!,
        "Jason Parser",
        "Jason Parser is an American singer-songwriter who first came to prominence in the San Diego coffee shop scene in 2000. In 2002.")
    items.add(item0)

    val item1 = RankingItem(
        ContextCompat.getDrawable(this, R.drawable.medal9)!!,
        ContextCompat.getDrawable(this, R.drawable.face2)!!,
        "Reactive Mars",
        "Reactive Mars known professionally is an American singer-songwriter, multi-instrumentalist, record producer, and choreographer.")
    items.add(item1)

    val item2 = RankingItem(
        ContextCompat.getDrawable(this, R.drawable.medal10)!!,
        ContextCompat.getDrawable(this, R.drawable.face3)!!,
        "Kotlin Perry",
        "Kotlin Perry is an American singer and songwriter.")
    items.add(item2)

    for (i in 0..4) {
      val item = RankingItem(
          ContextCompat.getDrawable(this, R.drawable.medal7)!!,
          ContextCompat.getDrawable(this, R.drawable.profile)!!,
          "Person$i",
          "This is sample listView Item.")
      items.add(item)
    }

    listView.adapter = adapter
  }

  fun fab(v: View) {
    startActivity(Intent(this, ExampleActivity::class.java))
  }
}
