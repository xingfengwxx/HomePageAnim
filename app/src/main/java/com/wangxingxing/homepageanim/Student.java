package com.wangxingxing.homepageanim;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author : 王星星
 * date : 2021/11/17 10:27
 * email : 1099420259@qq.com
 * description :
 */
public class Student implements Parcelable {
    public int id;
    public String name;

    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
