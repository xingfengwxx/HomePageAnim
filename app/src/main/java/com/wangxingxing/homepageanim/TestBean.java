package com.wangxingxing.homepageanim;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * author : 王星星
 * date : 2021/11/17 10:26
 * email : 1099420259@qq.com
 * description :
 */
public class TestBean implements Parcelable {
    public String name;
    public List<Student> students;

    protected TestBean(Parcel in) {
        name = in.readString();
        students = in.createTypedArrayList(Student.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(students);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TestBean> CREATOR = new Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel in) {
            return new TestBean(in);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };
}
