package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Path mPath = new Path();
    private Paint mPaint = new Paint();
    private Paint textPaint = new Paint();
    private Paint linePaint = new Paint();
    private String[] names = new String[]{"uou", "esf", "dfz", "wfdf"};

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(2);
        linePaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(150, 100);
        mPath.lineTo(150, 700);
        canvas.drawPath(mPath, linePaint);

        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(20);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.YELLOW);

        for (int i = 0; i < names.length; i++) {
            mPath.lineTo(150 + 250 * i, 700);
            canvas.drawPath(mPath, linePaint);
            canvas.drawText(names[i], 150 + 250 * i, 750, textPaint);
            canvas.drawRect(150 + 150 * i + 50, 50 * i, 150 + 150 * i + 100, 700, mPaint);
        }

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }
}
