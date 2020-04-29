package com.imooc.guessmusic.a2048;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * 2048的每个Item
 *
 * @author zq
 */
public class Game2048Item extends View {
    /**
     * 该View上的数字
     */
    private int mNumber;
    private String mNumberVal;
    private Paint mPaint;
    /**
     * 绘制文字的区域
     */
    private Rect mBound;


    //自定义字体
    Typeface typeface;

    public Game2048Item(Context context) {
        this(context, null);
    }

    public Game2048Item(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        typeface = Typeface.createFromAsset(context.getResources().getAssets(), "ClearSans-Bold.ttf");
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Game2048Item(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setNumber(int number) {
        mNumber = number;
        mNumberVal = number + "";
        mPaint.setTextSize(80);
        mPaint.setTypeface(typeface);
        mBound = new Rect();
        mPaint.getTextBounds(mNumberVal, 0, mNumberVal.length(), mBound);
        invalidate();
    }

    public int getNumber() {
        return mNumber;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String[] cellRectangleIds = getBackGroundIds();
        String mBgColor = cellRectangleIds[count(mNumber)];
        mPaint.setColor(Color.parseColor(mBgColor));

        RectF rect = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rect, 20, 20, mPaint);
        if (mNumber != 0) {
            if (mNumber < 8) {
                mPaint.setColor(Color.rgb(119, 110, 101));
            } else {
                mPaint.setColor(Color.WHITE);
            }
            float x = (getWidth() - mBound.width()) / 2;
            float y = getHeight() / 2 + mBound.height() / 2;
            canvas.drawText(mNumberVal, x, y, mPaint);
        }
    }

    public int[] getCellRectangleIds() {
        int[] cellRectangleIds = new int[21];
        cellRectangleIds[0] = R.drawable.cell_rectangle;
        cellRectangleIds[1] = R.drawable.cell_rectangle_2;
        cellRectangleIds[2] = R.drawable.cell_rectangle_4;
        cellRectangleIds[3] = R.drawable.cell_rectangle_8;
        cellRectangleIds[4] = R.drawable.cell_rectangle_16;
        cellRectangleIds[5] = R.drawable.cell_rectangle_32;
        cellRectangleIds[6] = R.drawable.cell_rectangle_64;
        cellRectangleIds[7] = R.drawable.cell_rectangle_128;
        cellRectangleIds[8] = R.drawable.cell_rectangle_256;
        cellRectangleIds[9] = R.drawable.cell_rectangle_512;
        cellRectangleIds[10] = R.drawable.cell_rectangle_1024;
        cellRectangleIds[11] = R.drawable.cell_rectangle_2048;
        for (int i = 12; i < cellRectangleIds.length; i++) {
            cellRectangleIds[i] = R.drawable.cell_rectangle_4096;
        }
        return cellRectangleIds;
    }

    public String[] getBackGroundIds() {
        String[] cellRectangleIds = new String[21];
        cellRectangleIds[0] = "#d6cdc4";
        cellRectangleIds[1] = "#eee4da";
        cellRectangleIds[2] = "#ede0c8";
        cellRectangleIds[3] = "#f2b179";
        cellRectangleIds[4] = "#f59563";
        cellRectangleIds[5] = "#f67c5f";
        cellRectangleIds[6] = "#f65e3b";
        cellRectangleIds[7] = "#edcf72";
        cellRectangleIds[8] = "#edcc61";
        cellRectangleIds[9] = "#edc850";
        cellRectangleIds[10] = "#edc53f";
        cellRectangleIds[11] = "#edc22e";
        for (int i = 12; i < cellRectangleIds.length; i++) {
            cellRectangleIds[i] = "#3c3a32";
        }
        return cellRectangleIds;
    }

    public int count(int number) {
        int result = 1, count = 0;
        while (result < number) {
            result *= 2;
            count++;
        }
        return count;
    }
}

































