package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    private static final int RADIUS = 260;
    private int[] angles = {60, 10, 70, 100, 120};
    private int[] colors = {Color.parseColor("#0f0f34"),
            Color.parseColor("#00ff87"), Color.parseColor("#f0ff45"), Color.parseColor("#0f0f98"),
            Color.parseColor("#348702")};
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rect = new RectF();
    private int currentAngle;
    private int changeNum = 2;
    private static final int MOVE_LENGTH = 30;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rect.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < angles.length; i++) {
            paint.setColor(colors[i]);
            canvas.save();
            if (changeNum == i) {
                canvas.translate((float) Math.cos(Math.toRadians(currentAngle + angles[i] / 2)) * MOVE_LENGTH, (float) Math.sin(Math.toRadians(currentAngle + angles[i] / 2)) * MOVE_LENGTH);
            }
            canvas.drawArc(rect, currentAngle, angles[i], true, paint);
            canvas.restore();
            currentAngle += angles[i];
        }
    }
}
