package com.wangkm.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
* @author: created by wangkm
* @Time: 2019-04-23
* @Des：
* @Email: kangmao.wang@foxmail.com
*/
public class CanvasOprationView extends View {
    public CanvasOprationView(Context context) {
        super(context);
    }

    public CanvasOprationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasOprationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 平移操作
         */
//        translateDemo(canvas);

        /**
         * 旋转操作
         */
//        rotateDemo(canvas);

        /**
         * 缩放操作
         */
//        scaleDemo(canvas);

        /**
         * 扭曲操作
         */
//        skewDemo(canvas);





//        canvas.drawColor(Color.RED);
//        canvas.clipRect(new Rect(100, 100, 200, 200));
//        canvas.drawColor(Color.GREEN);







        canvas.drawColor(Color.RED);
        //保存的画布大小为全屏幕大小
        int c1 = canvas.save();

        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.GREEN);
        //保存画布大小为Rect(100, 100, 800, 800)
        int c2 = canvas.save();

        canvas.clipRect(new Rect(200, 200, 700, 700));
        canvas.drawColor(Color.BLUE);
        //保存画布大小为Rect(200, 200, 700, 700)
        int c3 = canvas.save();

        canvas.clipRect(new Rect(300, 300, 600, 600));
        canvas.drawColor(Color.BLACK);
        //保存画布大小为Rect(300, 300, 600, 600)
        int c4 = canvas.save();

        canvas.clipRect(new Rect(400, 400, 500, 500));
        canvas.drawColor(Color.WHITE);

        //连续出栈三次，将最后一次出栈的Canvas状态作为当前画布，并画成黄色背景
        canvas.restoreToCount(c2);
        canvas.drawColor(Color.YELLOW);
    }

    private void translateDemo(Canvas canvas) {
        //translate  平移,即改变坐标系原点位置

        //构造两个画笔，一个红色，一个绿色
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 3);

        //构造一个矩形
        Rect rect1 = new Rect(0,0,400,220);

        //在平移画布前用绿色画下边框
        canvas.drawRect(rect1, paint_green);

        //平移画布后,再用红色边框重新画下这个矩形
        canvas.translate(100, 100);
        canvas.drawRect(rect1, paint_red);
    }


    private void rotateDemo(Canvas canvas){
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.FILL, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);

        Rect rect1 = new Rect(300,10,500,100);
        canvas.drawRect(rect1, paint_red); //画出原轮廓

        canvas.rotate(30);//顺时针旋转画布
        canvas.drawRect(rect1, paint_green);//画出旋转后的矩形
    }

    private void scaleDemo(Canvas canvas){
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);
        Paint paint_yellow   = generatePaint(Color.YELLOW, Paint.Style.STROKE, 5);

        Rect rect1 = new Rect(10,10,200,100);
        canvas.drawRect(rect1, paint_green);

        canvas.scale(0.5f, 1);
        canvas.drawRect(rect1, paint_red);
    }

    private void skewDemo(Canvas canvas){
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);

        Rect rect1 = new Rect(10,10,200,100);

        canvas.drawRect(rect1, paint_green);

        /**
         * 对于skey(float sx,float sy),sx和sy分别表示将画布在x和y方向上倾斜相应的角度对应的tan值。
         * 当sx=1时，即将画布在x方向上旋转45度，其实就是x轴保持方向不变，y轴逆时针旋转45度。
         * 当sy=1时，即将画布在y方向上旋转45度，其实就是y轴保持方向不变，x轴顺时针旋转45度。
         * 当sx、sy都改变时，两者都进行相应的移动。最后一张图中，将画布往x方向旋转45端，y方向旋转60度，可见，x轴顺时针旋转了60度，y逆时针旋转了45度。
         */
        canvas.skew(1.732f,0);//X轴倾斜60度，Y轴不变
        canvas.drawRect(rect1, paint_red);
    }

    private Paint generatePaint(int color,Paint.Style style,int width){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}
