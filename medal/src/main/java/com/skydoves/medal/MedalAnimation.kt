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

import android.graphics.Camera
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation

/** creates a [MedalAnimation] by [MedalAnimation.Builder] using dsl. */
fun medalAnimation(block: MedalAnimation.Builder.() -> Unit): MedalAnimation =
  MedalAnimation.Builder().apply(block).build()

/** MedalAnimation implements medal effects for views. */
class MedalAnimation(private val builder: Builder) : Animation() {

  private val degreeX: Float
  private var degreeY: Float
  private val degreeZ: Float

  private var width = 0
  private var height = 0

  init {
    this.degreeX = builder.degreeX.toFloat()
    this.degreeY = (360 * builder.turn).toFloat()
    this.degreeZ = builder.degreeZ.toFloat()

    if (builder.direction == MedalDirection.LEFT) {
      this.degreeY = -this.degreeY
    }

    this.duration = builder.speed.toLong()

    if (builder.loop == 0) {
      this.repeatCount = INFINITE
    } else {
      this.repeatCount = builder.loop - 1
    }
  }

  override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
    super.initialize(width, height, parentWidth, parentHeight)
    this.width = width / 2
    this.height = height / 2
  }

  override fun applyTransformation(interpolatedTime: Float, transformation: Transformation) {
    val xDegrees = degreeX * interpolatedTime
    val yDegrees = degreeY * interpolatedTime
    val zDegrees = degreeZ * interpolatedTime
    val matrix = transformation.matrix
    val camera = Camera()
    camera.apply {
      save()
      rotateX(xDegrees)
      rotateY(yDegrees)
      rotateZ(zDegrees)
      getMatrix(matrix)
      restore()
    }

    matrix.preTranslate((-this.width).toFloat(), (-this.height).toFloat())
    matrix.postTranslate(this.width.toFloat(), this.height.toFloat())
  }

  fun startAnimation(view: View) {
    if (view is ViewGroup && builder.target == MedalTarget.CHILDREN) {
      for (i in 0 until view.childCount) {
        view.getChildAt(i).startAnimation(builder.build())
      }
    } else {
      view.startAnimation(builder.build())
    }
  }

  /** builder class for creating [MedalAnimation]. */
  class Builder {
    @JvmField
    var target: MedalTarget = MedalTarget.CHILDREN
    @JvmField
    var direction: MedalDirection = MedalDirection.RIGHT
    @JvmField
    var turn = 1
    @JvmField
    var loop = 0
    @JvmField
    var speed = 2500
    @JvmField
    var degreeX = 0
    @JvmField
    var degreeZ = 0

    fun setTarget(medalTarget: MedalTarget): Builder = apply { this.target = medalTarget }
    fun setDirection(medalDirection: MedalDirection): Builder = apply { this.direction = medalDirection }
    fun setTurn(turn: Int): Builder = apply { this.turn = turn }
    fun setLoop(loop: Int): Builder = apply { this.loop = loop }
    fun setSpeed(speed: Int): Builder = apply { this.speed = speed }
    fun setDegreeX(degreeX: Int): Builder = apply { this.degreeX = degreeX }
    fun setDegreeZ(degreeZ: Int): Builder = apply { this.degreeZ = degreeZ }
    fun build(): MedalAnimation {
      return MedalAnimation(this)
    }
  }
}
