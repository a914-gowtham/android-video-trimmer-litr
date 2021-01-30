package com.videotrimmer.library.utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @CompressOption
 **/
public class CompressOption implements Parcelable {

    private int frameRate=30;

    private int bitRate;

    private int width;

    private int height;

    public CompressOption() {
    }

    /**
     * @param bitRate is describing the average bitrate in mb/sec.
     */
    public CompressOption(int bitRate) {
        this.bitRate = bitRate;
    }


    /**
     * @param frameRate is the frame rate of a video format in frames/sec.
     * @param bitRate is describing the average bitrate in mb/sec.
     */
    public CompressOption(int frameRate, int bitRate) {
        this.frameRate = frameRate;
        this.bitRate = bitRate;
    }

    /**
     * @param frameRate is the frame rate of a video format in frames/sec.
     * @param bitRate is describing the average bitrate in mb/sec.
     * @param height is describing the height of the video.
     * @param width is describing the width of the video.
     */
    public CompressOption(int frameRate, int bitRate, int width, int height) {
        this.frameRate = frameRate;
        this.bitRate = bitRate;
        this.width = width;
        this.height = height;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public int getBitRate() {
        return bitRate;
    }

    public static Creator<CompressOption> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.frameRate);
        dest.writeInt(this.bitRate);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }

    protected CompressOption(Parcel in) {
        this.frameRate = in.readInt();
        this.bitRate = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    public static final Creator<CompressOption> CREATOR = new Creator<CompressOption>() {
        @Override
        public CompressOption createFromParcel(Parcel source) {
            return new CompressOption(source);
        }

        @Override
        public CompressOption[] newArray(int size) {
            return new CompressOption[size];
        }
    };
}