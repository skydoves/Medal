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
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class MedalAnimation extends Animation {

    private Camera camera;
    private final float degreeX;
    private float degreeY;
    private final float degreeZ;

    private int width = 0;
    private int height = 0;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private MedalAnimation(Builder builder) {
        this.degreeX = builder.degreeX;
        this.degreeY = 360 * builder.turn;
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
        private int direction = -1;
        private int turn = 1;
        private int loop = 0;
        private int speed = 2500;
        private int degreeX = 0;
        private int degreeZ = 0;

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

        public MedalAnimation build() {
            return new MedalAnimation(this);
        }
    }
}