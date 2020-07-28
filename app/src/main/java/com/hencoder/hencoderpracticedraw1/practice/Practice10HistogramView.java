package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * android直方图 http://blog.csdn.net/clpliji/article/details/7998975
 */
public class Practice10HistogramView extends View {

    private Path mPath = new Path();
    private Paint mPaint = new Paint();
    private Paint textPaint = new Paint();
    private Paint linePaint = new Paint();
    private String[] names = new String[]{"one", "two", "three", "four"};
    private static final int LENGTH = 100;
    private static final int NUM = 5;
    private static final int GAP = 50;
    private Random random;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    {
        random = new Random();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(2);
        linePaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(150, 100);
        mPath.lineTo(150, 700);
        mPath.lineTo(900, 700);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);

        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30);
        textPaint.setTextAlign(Paint.Align.CENTER);

        canvas.drawPath(mPath, linePaint);
        for (int i = 0; i < names.length; i++) {
            int start = 150 + GAP * (i+1) + LENGTH * i;
            canvas.drawRect(start,700 -  100* random.nextInt(8),start + LENGTH, 700, mPaint);
            canvas.drawText(names[i],start + LENGTH/2, 700 + 30,textPaint);
        }

//        textPaint.setColor(Color.WHITE);
//        textPaint.setTextSize(20);
//
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.YELLOW);
//
//        for (int i = 0; i < names.length; i++) {
//            mPath.lineTo(150 + LENGTH * i, 700);
//            canvas.drawPath(mPath, linePaint);
//            canvas.drawText(names[i], 150 + LENGTH * i, 750, textPaint);
//            canvas.drawRect(150 + 150 * i + 50, 50 * i, 150 + 150 * i + 100, 700, mPaint);
//        }
    }
}
