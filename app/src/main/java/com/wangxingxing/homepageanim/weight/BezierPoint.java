package com.wangxingxing.homepageanim.weight;

import android.graphics.Point;

/**
 * author : 王星星
 * date : 2021/4/21 16:17
 * email : 1099420259@qq.com
 * description : 二阶贝塞尔曲线控制点
 */
public class BezierPoint {

    public Point startPoint;
    public Point controlPoint;
    public Point endPoint;

    public BezierPoint(Point startPoint, Point controlPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.controlPoint = controlPoint;
        this.endPoint = endPoint;
    }

}
