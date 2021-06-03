package com.wangxingxing.homepageanim.bean;

import com.wangxingxing.homepageanim.R;

/**
 * author : 王星星
 * date : 2021/6/2 12:02
 * email : 1099420259@qq.com
 * description :
 */
public class ItemBean {

    private boolean isCheck;
    private String content;

    public ItemBean(boolean isCheck, String content) {
        this.isCheck = isCheck;
        this.content = content;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "isCheck=" + isCheck +
                ", content='" + content + '\'' +
                '}';
    }
}
