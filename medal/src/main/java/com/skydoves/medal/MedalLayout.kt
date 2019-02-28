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
package com.skydoves.medal

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.FrameLayout

/** MedalLayout implements medal effects for itself and child views. */
class MedalLayout : FrameLayout {

  lateinit var medalAnimation: MedalAnimation

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    getAttrs(attrs)
  }

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    getAttrs(attrs, defStyleAttr)
  }

  private fun getAttrs(attrs: AttributeSet) {
    val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MedalLayout)
    setTypeArray(typedArray)
  }

  private fun getAttrs(attrs: AttributeSet, defStyle: Int) {
    val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MedalLayout, defStyle, 0)
    setTypeArray(typedArray)
  }

  private fun setTypeArray(typedArray: TypedArray) {
    this.medalAnimation = MedalAnimation.Builder()
        .setDegreeX(
            typedArray.getInt(R.styleable.MedalLayout_degreeX, MedalAnimation.DEFAULT_DEGREE_X))
        .setDegreeZ(
            typedArray.getInt(R.styleable.MedalLayout_degreeZ, MedalAnimation.DEFAULT_DEGREE_Z))
        .setDirection(
            typedArray.getInt(
                R.styleable.MedalLayout_direction, MedalAnimation.DEFAULT_DIRECTION))
        .setSpeed(
            typedArray.getInt(R.styleable.MedalLayout_speed, MedalAnimation.DEFAULT_SPEED))
        .setTurn(typedArray.getInt(R.styleable.MedalLayout_turn, MedalAnimation.DEFAULT_TURN))
        .setType(typedArray.getInt(R.styleable.MedalLayout_type, MedalAnimation.DEFAULT_TARGET))
        .setLoop(typedArray.getInt(R.styleable.MedalLayout_loop, MedalAnimation.DEFAULT_LOOP))
        .build()
  }

  override fun onFinishInflate() {
    super.onFinishInflate()
    this.medalAnimation.startAnimation(this)
  }
}
