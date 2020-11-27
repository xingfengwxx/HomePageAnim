package com.wangxingxing.homepageanim.flex;

import java.util.Date;

/**
 * author : 王星星
 * date : 2020/11/27 17:39
 * email : 1099420259@qq.com
 * description :
 */
public class SearchHistoryBean {
    private String searchTitle;//搜索的标题
    private Date searchDate;//搜索的时间（如果重新搜索了的话，只需要更新搜索时间即可，不需要添加）

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }
}
