package com.msz.motionlayout.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class BoundsImageView extends ImageView {
    private Paint mPaint = new Paint();

    public BoundsImageView(Context context) {
        this(context, null);
    }

    public BoundsImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BoundsImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setARGB(255, 200, 0, 0);
        mPaint.setStrokeWidth(4f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, getWidth(), getHeight(), mPaint);
        canvas.drawLine(0, getHeight(), getWidth(), 0, mPaint);
    }
}
