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

package com.skydoves.medal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MedalLayout extends RelativeLayout {

    public MedalLayout(Context context) {
        super(context);
    }

    public MedalLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
    }

    public MedalLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(attrs, defStyleAttr);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MedalLayout);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MedalLayout, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
        final MedalAnimation medalAnimation = new MedalAnimation.Builder()
                .setDegreeX(typedArray.getInt(R.styleable.MedalLayout_degreeX, MedalAnimation.DEFAULT_DEGREE_X))
                .setDegreeZ(typedArray.getInt(R.styleable.MedalLayout_degreeZ, MedalAnimation.DEFAULT_DEGREE_Z))
                .setDirection(typedArray.getInt(R.styleable.MedalLayout_direction, MedalAnimation.DEFAULT_DIRECTION))
                .setSpeed(typedArray.getInt(R.styleable.MedalLayout_speed, MedalAnimation.DEFAULT_SPEED))
                .setTurn(typedArray.getInt(R.styleable.MedalLayout_turn, MedalAnimation.DEFAULT_TURN))
                .setType(typedArray.getInt(R.styleable.MedalLayout_type, MedalAnimation.DEFAULT_TYPE))
                .setLoop(typedArray.getInt(R.styleable.MedalLayout_loop, MedalAnimation.DEFAULT_LOOP))
                .build();

        this.post(new Runnable() {
            @Override
            public void run() {
                onFinishDraw(medalAnimation);
            }
        });
    }

    private void onFinishDraw(MedalAnimation medalAnimation) {
        medalAnimation.startAnimation(this);
    }
}