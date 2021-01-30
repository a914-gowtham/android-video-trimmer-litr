package com.videotrimmer.library.utils;

import android.util.Log;

public class LogMessage {

    public static void v(String msg) {
            Log.v("VIDEO_TRIMMER ::", msg);
    }

    public static void e(String msg) {
            Log.e("VIDEO_TRIMMER ::", msg);
    }
}
