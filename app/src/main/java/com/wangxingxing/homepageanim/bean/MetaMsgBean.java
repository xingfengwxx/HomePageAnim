package com.wangxingxing.homepageanim.bean;

/**
 * author : 王星星
 * date : 2022/6/6 14:07
 * email : 1099420259@qq.com
 * description : 发送到Unity的消息格式
 */
public class MetaMsgBean<T> {

    public static final String PHASE_REQUEST = "request";
    public static final String PHASE_FEEDBACK = "feedback";
    public static final String PHASE_END = "end";
    public static final String PHASE_ONCE = "once";
    public static final String PHASE_START = "start";
    public static final String PHASE_STOP = "stop";

    public static final String TITLE_TAKE_PHOTO = "takephoto";
    public static final String TITLE_NEARBY_AVATARS = "NearbyAvatars";
    public static final String TITLE_SEND_FLOWER = "SendFlower";
    public static final String TITLE_CHA_CHA = "ChaCha";
    public static final String TITLE_JIAO_JI = "JiaoJi";

    //Json所代表的行为是什么
    public String title;

    //行为的阶段
    public String phase;

    //行为在这个阶段的细节信息
    public T data;

}
