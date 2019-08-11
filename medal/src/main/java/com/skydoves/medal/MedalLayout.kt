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

  private var isStarted: Boolean = false
  private var autoStart: Boolean = true
  private lateinit var medalAnimation: MedalAnimation

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
    try {
      val builder = MedalAnimation.Builder()
        .setDegreeX(
          typedArray.getInt(R.styleable.MedalLayout_degreeX, 0))
        .setDegreeZ(
          typedArray.getInt(R.styleable.MedalLayout_degreeZ, 0))
        .setSpeed(
          typedArray.getInt(R.styleable.MedalLayout_speed, 2500))
        .setTurn(typedArray.getInt(R.styleable.MedalLayout_turn, 1))
        .setLoop(typedArray.getInt(R.styleable.MedalLayout_loop, 0))

      val target = typedArray.getInt(R.styleable.MedalLayout_target, 0)
      var medalTarget = MedalTarget.CHILDREN
      if (target == 1) medalTarget = MedalTarget.PARENT
      builder.setTarget(medalTarget)

      val direction = typedArray.getInt(R.styleable.MedalLayout_direction, 0)
      var medalDirection = MedalDirection.RIGHT
      if (direction == 1) medalDirection = MedalDirection.LEFT
      builder.setDirection(medalDirection)

      this.medalAnimation = builder.build()
      this.autoStart = typedArray.getBoolean(R.styleable.MedalLayout_autoStart, autoStart)
    } finally {
      typedArray.recycle()
    }
  }

  override fun onFinishInflate() {
    super.onFinishInflate()
    if (this.autoStart) {
      startAnimation()
    }
  }

  /** start medal animation. */
  fun startAnimation() {
    if (!isStarted()) {
      this.medalAnimation.startAnimation(this)
      this.isStarted = true
    }
  }

  /** gets the medal animation is started or not. */
  fun isStarted(): Boolean {
    return this.isStarted
  }
}
