# Medal
![license](https://img.shields.io/badge/license-MIT%20License-blue.svg)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![Build Status](https://travis-ci.org/skydoves/Medal.svg?branch=master)](https://travis-ci.org/skydoves/Medal) </br>
Easy way to implement medal effect for Android. <br>

![gif0](https://user-images.githubusercontent.com/24237865/53584338-b8b5db00-3bc6-11e9-8cfd-9c8f2ad7cc90.gif)
![gif1](https://user-images.githubusercontent.com/24237865/53584339-b94e7180-3bc6-11e9-8518-1bbb87b8f4ae.gif)

## Download
[![Download](https://api.bintray.com/packages/devmagician/maven/medal/images/download.svg)](https://bintray.com/devmagician/maven/medal/_latestVersion)
[![Jitpack](https://jitpack.io/v/skydoves/Medal.svg)](https://jitpack.io/#skydoves/Medal)

### Gradle
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
    repositories {
        jcenter()
    }
}
```

And add a dependency code to your **module**'s `build.gradle` file.

```gradle
dependencies {
    implementation "com.github.skydoves:medal:1.0.2"
}
```

## Usage
Add following XML namespace inside your XML layout file.

```gradle
xmlns:app="http://schemas.android.com/apk/res-auto"
```

### MedalLayout in layout
```gradle
<com.skydoves.medal.MedalLayout
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_weight="1"
    app:direction="right"
    app:turn="1"
    app:speed="1500">

    <ImageView
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:src="@drawable/medal2"
        android:layout_centerInParent="true"
        android:scaleType="fitXY"/>
  
</com.skydoves.medal.MedalLayout>
```

### create using builder
This is how to create `MedalAnimation`'s instance using `MedalAnimation.Builder` class.
```java
MedalAnimation medalAnimation = new MedalAnimation.Builder()
         .setDirection(MedalAnimation.LEFT)
         .setDegreeX(360)
         .setDegreeZ(360)
         .setSpeed(4200)
         .setTurn(4)
         .setLoop(10)
         .build();
```

### create using kotlin dsl
This is how to create `MedalAnimation`'s instance using kotlin dsl.
```kotlin 
val medalAnimation = medalAnimation {
     direction = MedalAnimation.LEFT
     speed = 4200
     turn = 4
}
```

### start animation
```java
medalAnimation.startAnimation(your_view);
```

or we can give medal effects using view's `startAnimation` method.

```java
ImageView imageView = findViewById(R.id.badge);
imageView.startAnimation(medalAnimation);
```

## MedalLayout Attributes
Parameter  |  Format  |  Default  |  Description
--- | --- | --- | ---
type | children or parent | children | target of animation
direction | right or left | right | direction of animation
turn | Integer | 1 | counts of turns per a loop (if turn value is 3, turn 3 per loop)
loop | Integer | infinite(0) | loop of animation
speed | Integer | 2300 | duration per loop
degreeX | Integer | 0 |  turning degree of axis x
degreeZ | Integer | 0 | turning degree of axis Z

## References
- [Medal Library Animation Demo App](http://www.digitalmirko.com/androidMedalLibraryAnimationDemoApp.html)
- [Using Medal library in Android Studio](https://www.youtube.com/watch?v=ohUWduZTZ-Y)
- [40 Top Awesome Android Libraries May](https://medium.com/pongploydev/top-android-libraries-may-september-2017-for-android-developer-library-github-280859685963)
- [How to Create Medal View In Android](https://www.youtube.com/watch?v=t2xsQaA6HGE)

# License
```xml
The MIT License (MIT)

Copyright (c) 2017 skydoves

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
