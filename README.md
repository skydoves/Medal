# Medal
Medal can be used to add medal effect to your Android views.<br>

![gif](https://user-images.githubusercontent.com/24237865/29002172-9dd7875e-7ad7-11e7-8929-4be72902ec5d.gif)
![gif2](https://user-images.githubusercontent.com/24237865/29002173-9dec8d16-7ad7-11e7-91e7-9a28a39043c0.gif)

## Download
#### build.gradle
```java
repositories {
  mavenCentral() // or jcenter() works as well
}

dependencies {
  compile 'com.github.skydoves:medal:1.0.1'
}
```

#### or Maven
```xml
<dependency>
  <groupId>com.github.skydoves</groupId>
  <artifactId>medal</artifactId>
  <version>1.0.1</version>
</dependency>
```

## Usage
### Medal Animation
You can give all of views or GroupViews medal effect.

#### Create Medal Animation Instance
You can make instance using Builder and customize using set() methods.
```xml
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
```xml
medalAnimation.startAnimation(findViewById(R.id.badge));
```

or
```xml
ImageView imageView = (ImageView)findViewById(R.id.badge);
imageView.startAnimation(medalAnimation);
```

### MedalLayout
You can use like using normal layouts and you can give all of Views or GroupViews medal effect very simply.

#### Add XML Namespace
First add below XML Namespace inside your XML layout file.

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

```xml
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
Copyright 2017 skydoves

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
