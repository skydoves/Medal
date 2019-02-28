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
package com.skydoves.medaldemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.skydoves.medal.MedalAnimation;
import java.util.ArrayList;

/** Developed by skydoves on 2019-02-28. Copyright (c) 2018 skydoves rights reserved. */
public class RankingAdapter extends BaseAdapter {
  private LayoutInflater inflater;
  private ArrayList<RankingItem> data;
  private int layout;

  public RankingAdapter(Context context, int layout, ArrayList<RankingItem> data) {
    this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.data = data;
    this.layout = layout;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public String getItem(int position) {
    return data.get(position).getContent();
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    if (convertView == null) convertView = inflater.inflate(layout, parent, false);

    RankingItem listviewitem = data.get(position);

    MedalAnimation medalAnimation = new MedalAnimation.Builder().setSpeed(4200).setTurn(4).build();

    ImageView imageView_medal = convertView.findViewById(R.id.medal);
    imageView_medal.setImageDrawable(listviewitem.getMedal());
    imageView_medal.startAnimation(medalAnimation);

    ImageView imageView_profile = convertView.findViewById(R.id.profile);
    imageView_profile.setImageDrawable(listviewitem.getProfile());

    TextView textView_name = convertView.findViewById(R.id.name);
    textView_name.setText(listviewitem.getName());

    TextView textView_content = convertView.findViewById(R.id.content);
    textView_content.setText(listviewitem.getContent());

    return convertView;
  }
}
