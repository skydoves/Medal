# Medal
![license](https://img.shields.io/badge/license-MIT%20License-blue.svg)</br>
A library that lets you implement medal animation.<br>

![gif](https://user-images.githubusercontent.com/24237865/29002172-9dd7875e-7ad7-11e7-8929-4be72902ec5d.gif)
![gif2](https://user-images.githubusercontent.com/24237865/29002173-9dec8d16-7ad7-11e7-91e7-9a28a39043c0.gif)

## Download
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
  implementation "com.github.skydoves:medal:1.0.1"
}
```

## Usage
### Medal Animation
You can give all of views or GroupViews medal effect.

#### Create Medal Animation Instance
You can make instance using Builder and customize using set() methods.
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

#### Apply Animation Example
```java
medalAnimation.startAnimation(findViewById(R.id.badge));
```
or
```java
ImageView imageView = (ImageView)findViewById(R.id.badge);
imageView.startAnimation(medalAnimation);
```

### MedalLayout
You can use like using normal layouts and you can give all of Views or GroupViews medal effect very simply.

#### Add XML Namespace
First add below XML Namespace inside your XML layout file.

```gradle
xmlns:app="http://schemas.android.com/apk/res-auto"
```

#### MedalLayout in layout
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

#### MedalLayout Attributes
Parameter  |  Format  |  Default  |  Description
--- | --- | --- | ---
type | children(0) or parent(1) | children(0) | target of animation
direction | right(0) or left(1) | right(0) | direction of animation
turn | Integer | 1 | counts of turns per a loop (if turn value is 3, turn 3 per loop)
loop | Integer | infinite(0) | loop of animation
speed | Integer | 2300 | duration per loop
degreeX | Integer | 0 |  turning degree of axis x
degreeZ | Integer | 0 | turning degree of axis Z

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
