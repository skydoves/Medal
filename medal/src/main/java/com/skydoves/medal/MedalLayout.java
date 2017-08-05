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
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public class MedalLayout extends RelativeLayout {

    private static final int parent = 0;
    private static final int children = 1;

    private int type = 0;
    private int direction = -1;
    private int turn = 1;
    private int loop = 0;
    private int speed = 2500;
    private int degreeX = 0;
    private int degreeZ = 0;

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
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.medal);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.medal, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
        type = typedArray.getInt(R.styleable.medal_type, type);
        direction = typedArray.getInt(R.styleable.medal_direction, direction);
        turn = typedArray.getInt(R.styleable.medal_turn, turn);
        loop = typedArray.getInt(R.styleable.medal_loop, loop);
        speed = typedArray.getInt(R.styleable.medal_speed, speed);
        degreeX = typedArray.getInt(R.styleable.medal_degreeX, degreeX);
        degreeZ = typedArray.getInt(R.styleable.medal_degreeZ, degreeZ);
        createAnimation();
    }

    private void createAnimation() {
        final MedalAnimation animation = new MedalAnimation.Builder()
                .setDegreeX(degreeX)
                .setDegreeZ(degreeZ)
                .setDirection(direction)
                .setSpeed(speed)
                .setTurn(turn)
                .setLoop(loop)
                .build();

        if(type == parent) {
            doParentAnimation(animation);
        } else if(type == children) {
            this.post(new Runnable() {
                @Override
                public void run() {
                    doChildrenAnimation(animation);
                }
            });
        }
    }

    private void doParentAnimation(Animation animation) {
        this.startAnimation(animation);
    }

    private void doChildrenAnimation(Animation animation) {
        for(int i=0; i<this.getChildCount(); i++)
            this.getChildAt(i).startAnimation(animation);
    }
}