[![MIT licensed](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/hyperium/hyper/master/LICENSE)
[![](https://jitpack.io/v/a914-gowtham/Android-video-trimmer.svg)](https://jitpack.io/#a914-gowtham/android-video-trimmer-litr)

# Android-video-trimmer

##### Light weight version of [Android-Video-Trimmer](https://github.com/a914-gowtham/Android-video-trimmer). It uses [LiTr library](https://github.com/linkedin/LiTr) as transcoder 

![](https://github.com/a914-gowtham/Android-video-trimmer/blob/master/demo.gif)

## How to use
*For a working implementation, please have a look at the Sample Project*

1. Include the library as local library project.

+ Add the dependency to your app `build.gradle` file
 ```gradle
 dependencies {
    implementation 'com.github.a914-gowtham:android-video-trimmer-litr:1.5.3'
 }
 ```
 + Add to project's root `build.gradle` file:
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
2. Add the code for opening Trim Activity.
```java
TrimVideo.activity(String.valueOf(videoUri))
//        .setCompressOption(new CompressOption()) //empty constructor for default compress option
          .setHideSeekBar(true)
          .setDestination("/storage/emulated/0/DCIM/TESTFOLDER")  //default output path /storage/emulated/0/DOWNLOADS
          .start(this);
```
3. Override `onActivityResult` method in your activity to get trim result
```java
@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == TrimVideo.VIDEO_TRIMMER_REQ_CODE && data != null) {
            Uri uri = Uri.parse(TrimVideo.getTrimmedVideoPath(data));
            Log.d(TAG,"Trimmed path:: "+uri);
        }
}
```
## Customization

#### Video Compress:
```java
.setCompressOption(new CompressOption(bitRate))  //pass empty constructor for default compressoption
```
  * `BitRate`   Bitrate Can be between 1 to 10.Lower bitrate can reduce the quality and size of the video.


#### Hide Player Seekbar:
```java
.setHideSeekBar(true) //default value is false 
```

### Custom TrimTypes

#### TrimType Default:
```java
TrimVideo.activity(videoUri)
          .start(this);
```

#### TrimType Fixed Duration:
```java
TrimVideo.activity(videoUri)
          .setTrimType(TrimType.FIXED_DURATION)
          .setFixedDuration(30) //seconds
          .start(this);
```

#### TrimType Minimum Duration:
```java
TrimVideo.activity(videoUri)
          .setTrimType(TrimType.MIN_DURATION)
          .setMinDuration(30) //seconds
          .start(this);
```

#### TrimType Min-Max Duration:
```java
TrimVideo.activity(videoUri)
          .setTrimType(TrimType.MIN_MAX_DURATION)
          .setMinToMax(10, 30)  //seconds
          .start(this);
```

## Proguard Rules
```pro
-dontwarn com.videotrimmer.library**
-keep class com.videotrimmer.library** { *; }
-keep interface com.videotrimmer.library** { *; }
```

## Compatibility
  
  * Library - Android Kitkat 4.4+ (API 19)
  * Sample - Android Kitkat 4.4+ (API 19)
  
## ChangeLog
### Version 1.5.3
  * First version
  
## Acknowledgement
[LiTr](https://github.com/linkedin/LiTr)

## Support 
Show your support by giving a star to this repository.so this can keep me motivated to make improvements 
  
## Collaboration
There are many ways of improving and adding more features, so feel free to collaborate with ideas, issues and/or pull requests. 
