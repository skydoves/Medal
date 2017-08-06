/*
 * Copyright (C) 2017 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.medaldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.skydoves.medal.MedalAnimation;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MedalAnimation medalAnimation_tv = new MedalAnimation.Builder()
                .setSpeed(3000)
                .setTurn(1)
                .build();

        TextView textView = (TextView)findViewById(R.id.textView_title);
        textView.startAnimation(medalAnimation_tv);

        MedalAnimation medalAnimation = new MedalAnimation.Builder()
                .setDirection(MedalAnimation.LEFT)
                .setSpeed(4200)
                .setTurn(4)
                .build();

        ImageView imageView = (ImageView)findViewById(R.id.badge);
        imageView.startAnimation(medalAnimation);
    }
}