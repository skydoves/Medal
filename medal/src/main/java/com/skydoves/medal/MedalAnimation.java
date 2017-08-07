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

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class MedalAnimation extends Animation {

    private Camera camera;
    private final float degreeX;
    private float degreeY;
    private final float degreeZ;

    private int width = 0;
    private int height = 0;

    private Builder builder;

    public static final int PARENT = 1;
    public static final int LEFT = 1;
    public static final int DEFAULT_DEGREE = 360;

    public static final int DEFAULT_TYPE = -1;
    public static final int DEFAULT_DIRECTION = 0;
    public static final int DEFAULT_TURN = 1;
    public static final int DEFAULT_LOOP = 0;
    public static final int DEFAULT_SPEED = 2500;
    public static final int DEFAULT_DEGREE_X = 0;
    public static final int DEFAULT_DEGREE_Z = 0;

    private MedalAnimation(Builder builder) {
        this.builder = builder;
        this.degreeX = builder.degreeX;
        this.degreeY = DEFAULT_DEGREE * builder.turn;
        this.degreeZ = builder.degreeZ;

        if(builder.direction == LEFT) {
            this.degreeY = -this.degreeY;
        }

        this.setDuration(builder.speed);

        if(builder.loop == 0) {
            this.setRepeatCount(Animation.INFINITE);
        } else {
            this.setRepeatCount(builder.loop-1);
        }
    }

    public void startAnimation(View view) {
        try {
            view.startAnimation(builder.build());
        } catch (Exception e) {
            throw new RuntimeException("parent medal animation runtime exception");
        }
    }

    public void startAnimation(ViewGroup viewGroup) {
        if(builder.getType() == PARENT) {
            viewGroup.startAnimation(builder.build());
        } else {
            try {
                MedalAnimation medalAnimation = builder.build();
                for (int i = 0; i < viewGroup.getChildCount(); i++)
                    viewGroup.getChildAt(i).startAnimation(medalAnimation);
            } catch (Exception e) {
                throw new RuntimeException("child medal animation runtime exception");
            }
        }
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.camera = new Camera();
        this.width = width / 2;
        this.height = height / 2;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float xDegrees = degreeX * interpolatedTime;
        float yDegrees = degreeY * interpolatedTime;
        float zDegrees = degreeZ * interpolatedTime;
        final Matrix matrix = t.getMatrix();

        camera.save();
        camera.rotateX(xDegrees);
        camera.rotateY(yDegrees);
        camera.rotateZ(zDegrees);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-this.width, -this.height);
        matrix.postTranslate(this.width, this.height);
    }

    public static class Builder {
        private int type = DEFAULT_TYPE;
        private int direction = DEFAULT_DIRECTION;
        private int turn = DEFAULT_TURN;
        private int loop = DEFAULT_LOOP;
        private int speed = DEFAULT_SPEED;
        private int degreeX = DEFAULT_DEGREE_X;
        private int degreeZ = DEFAULT_DEGREE_Z;

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public Builder setDirection(int direction) {
            this.direction = direction;
            return this;
        }

        public Builder setTurn(int turn) {
            this.turn = turn;
            return this;
        }

        public Builder setLoop(int loop) {
            this.loop = loop;
            return this;
        }

        public Builder setSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder setDegreeX(int degreeX) {
            this.degreeX = degreeX;
            return this;
        }

        public Builder setDegreeZ(int degreeZ) {
            this.degreeZ = degreeZ;
            return this;
        }

        public int getType() {
            return type;
        }

        public MedalAnimation build() {
            return new MedalAnimation(this);
        }
    }
}