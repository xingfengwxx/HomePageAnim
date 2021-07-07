package com.wangxingxing.homepageanim.bean;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * author : 王星星
 * date : 2021/6/4 12:06
 * email : 1099420259@qq.com
 * description : 检测模拟器配置
 * 配置文件地址：https://cdn.sbnh.cn/emulator_config.json
 */
public class CheckEmulatorBean {


    //不检测模拟器
    public static final int CHECK_NOT = 0;
    //检测级别：低
    public static final int CHECK_LOW = 1;
    //检测级别：中
    public static final int CHECK_MIDDLE = 2;
    //检测级别：高
    public static final int CHECK_HIGH = 3;

    @IntDef({CHECK_NOT, CHECK_LOW, CHECK_MIDDLE, CHECK_HIGH})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LEVEL { }

    //检测模拟器等级
    private @LEVEL int checkLevel;
    //文件更新时间
    private String date;
    //文件版本,从1开始，修改后每次+1，
    private int versionCode;

    public int getCheckLevel() {
        return checkLevel;
    }

    public void setCheckLevel(int checkLevel) {
        this.checkLevel = checkLevel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    @Override
    public String toString() {
        return "CheckEmulatorBean{" +
                "checkLevel=" + checkLevel +
                ", date='" + date + '\'' +
                ", versionCode=" + versionCode +
                '}';
    }
}
