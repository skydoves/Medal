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

import android.graphics.drawable.Drawable;

/** Developed by skydoves on 2019-02-28. Copyright (c) 2018 skydoves rights reserved. */
public class RankingItem {
  private Drawable medal;
  private Drawable profile;
  private String name;
  private String content;

  public RankingItem(Drawable medal, Drawable profile, String name, String content) {
    this.medal = medal;
    this.profile = profile;
    this.name = name;
    this.content = content;
  }

  public Drawable getMedal() {
    return medal;
  }

  public Drawable getProfile() {
    return profile;
  }

  public String getName() {
    return name;
  }

  public String getContent() {
    return content;
  }
}
