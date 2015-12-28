package com.joyfulmath.sample.javanetwork;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author deman.lu on 2015-12-24 11:08
 * email    luyuanchun032@pingan.com.cn
 */
public class GsonBean implements Parcelable {

    /**
     * iCheckinScore : 5
     * iTotalScore : 200
     */

    private int iCheckinScore;
    private int iTotalScore;

    public void setICheckinScore(int iCheckinScore) {
        this.iCheckinScore = iCheckinScore;
    }

    public void setITotalScore(int iTotalScore) {
        this.iTotalScore = iTotalScore;
    }

    public int getICheckinScore() {
        return iCheckinScore;
    }

    public int getITotalScore() {
        return iTotalScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.iCheckinScore);
        dest.writeInt(this.iTotalScore);
    }

    public GsonBean() {
    }

    protected GsonBean(Parcel in) {
        this.iCheckinScore = in.readInt();
        this.iTotalScore = in.readInt();
    }

    public static final Parcelable.Creator<GsonBean> CREATOR = new Parcelable.Creator<GsonBean>() {
        public GsonBean createFromParcel(Parcel source) {
            return new GsonBean(source);
        }

        public GsonBean[] newArray(int size) {
            return new GsonBean[size];
        }
    };
}
