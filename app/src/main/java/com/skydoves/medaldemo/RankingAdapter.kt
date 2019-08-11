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

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.skydoves.medal.MedalAnimation
import java.util.ArrayList

class RankingAdapter(
  private val context: Context,
  private val layout: Int,
  private val data: ArrayList<RankingItem>
) : BaseAdapter() {

  override fun getCount(): Int {
    return data.size
  }

  override fun getItem(position: Int): String {
    return data[position].content
  }

  override fun getItemId(position: Int): Long {
    return position.toLong()
  }

  @SuppressLint("ViewHolder")
  override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val rootView = inflater.inflate(layout, parent, false)

    val listviewitem = data[position]

    val medalAnimation = MedalAnimation.Builder().setSpeed(4200).setTurn(4).build()

    val imageView_medal = rootView!!.findViewById<ImageView>(R.id.medal)
    imageView_medal.setImageDrawable(listviewitem.medal)
    imageView_medal.startAnimation(medalAnimation)

    val imageView_profile = rootView.findViewById<ImageView>(R.id.profile)
    imageView_profile.setImageDrawable(listviewitem.profile)

    val textView_name = rootView.findViewById<TextView>(R.id.name)
    textView_name.text = listviewitem.name

    val textView_content = rootView.findViewById<TextView>(R.id.content)
    textView_content.text = listviewitem.content

    return rootView
  }
}
