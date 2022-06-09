package com.wangxingxing.homepageanim.bean;

/**
 * author : 王星星
 * date : 2022/6/1 10:28
 * email : 1099420259@qq.com
 * description :
 */
public class DanceInfo {

    public String uid_self;
    public String uid_other;
    public String danceType;

    @Override
    public String toString() {
        return "DanceInfo{" +
                "uid_self='" + uid_self + '\'' +
                ", uid_other='" + uid_other + '\'' +
                ", danceType='" + danceType + '\'' +
                '}';
    }
}
