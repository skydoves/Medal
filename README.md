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
  compile 'com.github.skydoves:medal:1.0.0'
}
```

#### or Maven
```xml
<dependency>
  <groupId>com.github.skydoves</groupId>
  <artifactId>medal</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage
You can use like using normal animation or layouts and you can give all of Views or GroupViews medal effect very simply.

### Medal Animation
You can give all of views or GroupViews medal effect.

#### Create Medal Animation Instance
You can make instance using Builder and customize using set() methods.
```xml
MedalAnimation medalAnimation = new MedalAnimation.Builder()
                .setDirection(MedalAnimation.LEFT) // default direction is RIGHT
                .setDegreeX(360) // default degreeX is 0
                .setDegreeZ(360) // default degreeZ is 0
                .setSpeed(4200) // default speed is 2300
                .setTurn(4) // default turn is 1
                .setLoop(10) // default loop is infinite loop
                .build();
```

#### Apply Animation Example
```xml
ImageView imageView = (ImageView)findViewById(R.id.badge);
imageView.startAnimation(medalAnimation);
```

### MedalLayout
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
```xml
type | parent or children
direction | left or right
turn | Integer // successive turning count.
speed | Integer
loop | Integer // default is infinite loop. but if you set loop attr, just looping the number and end.
degreeX | Integer
degreeZ | Integer
```

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
