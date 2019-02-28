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
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.skydoves.medal.MedalAnimation;
import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rankling);

    ListView listView = (ListView) findViewById(R.id.listView);

    ArrayList<Listviewitem> items = new ArrayList<>();
    ListviewAdapter adapter = new ListviewAdapter(this, R.layout.item_rank, items);

    Listviewitem item0 =
        new Listviewitem(
            ContextCompat.getDrawable(this, R.drawable.medal2),
            ContextCompat.getDrawable(this, R.drawable.face1),
            "Jason Parser",
            "Jason Parser is an American singer-songwriter who first came to prominence in the San Diego coffee shop scene in 2000. In 2002.");
    items.add(item0);

    Listviewitem item1 =
        new Listviewitem(
            ContextCompat.getDrawable(this, R.drawable.medal9),
            ContextCompat.getDrawable(this, R.drawable.face2),
            "Reactive Mars",
            "Reactive Mars known professionally is an American singer-songwriter, multi-instrumentalist, record producer, and choreographer.");
    items.add(item1);

    Listviewitem item2 =
        new Listviewitem(
            ContextCompat.getDrawable(this, R.drawable.medal10),
            ContextCompat.getDrawable(this, R.drawable.face3),
            "Kotlin Perry",
            "Kotlin Perry is an American singer and songwriter.");
    items.add(item2);

    for (int i = 0; i < 5; i++) {
      Listviewitem item =
          new Listviewitem(
              ContextCompat.getDrawable(this, R.drawable.medal7),
              ContextCompat.getDrawable(this, R.drawable.profile),
              "Person" + i,
              "This is sample listView Item.");
      items.add(item);
    }

    listView.setAdapter(adapter);
  }

  public void fab(View v) {
    startActivity(new Intent(this, ExampleActivity.class));
  }

  private class ListviewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Listviewitem> data;
    private int layout;

    public ListviewAdapter(Context context, int layout, ArrayList<Listviewitem> data) {
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

      Listviewitem listviewitem = data.get(position);

      MedalAnimation medalAnimation =
          new MedalAnimation.Builder().setSpeed(4200).setTurn(4).build();

      ImageView imageView_medal = (ImageView) convertView.findViewById(R.id.medal);
      imageView_medal.setImageDrawable(listviewitem.getMedal());
      imageView_medal.startAnimation(medalAnimation);

      ImageView imageView_profile = (ImageView) convertView.findViewById(R.id.profile);
      imageView_profile.setImageDrawable(listviewitem.getProfile());

      TextView textView_name = (TextView) convertView.findViewById(R.id.name);
      textView_name.setText(listviewitem.getName());

      TextView textView_content = (TextView) convertView.findViewById(R.id.content);
      textView_content.setText(listviewitem.getContent());

      return convertView;
    }
  }

  private class Listviewitem {
    private Drawable medal;
    private Drawable profile;
    private String name;
    private String content;

    public Listviewitem(Drawable medal, Drawable profile, String name, String content) {
      this.medal = medal;
      this.profile = profile;
      this.name = name;
      this.content = content;
    }

    public Drawable getMedal() {
      return medal;
    }

    private Drawable getProfile() {
      return profile;
    }

    private String getName() {
      return name;
    }

    public String getContent() {
      return content;
    }
  }
}
