package com.example.maqingwei.customviewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by maqingwei
 * Date on 16/8/25 下午12:09
 *
 * @Description:自定义点击计数的View
 */
public class CountTextView extends TextView {

    //声明相应的属性变量
    private String mTextContent;
    private int mTextColor;
    private float mTextSize;
    private int mCounts;

    //声明画笔和边界
   private Paint mPaint;
   private Rect mBound;


    public CountTextView(Context context) {
        super(context);
    }

    public CountTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //将xml中的自定义属性 映射到attrs中,从typedarray中获取相应的自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CountTextView);

        mTextContent = typedArray.getString(R.styleable.CountTextView_textCotent);
        mTextColor = typedArray.getColor(R.styleable.CountTextView_textColor,Color.BLACK);
        mTextSize = typedArray.getDimension(R.styleable.CountTextView_textSize,14);

        //使用完资源回收 以免造成内存泄漏
        typedArray.recycle();

        //获取文本的宽和高
        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);

        mBound = new Rect();
        //getBounds获取字的宽度和高度
        mPaint.getTextBounds(mTextContent,0,mTextContent.length(),mBound);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                mTextContent = ++mCounts+"";
                if (mTextContent.length() == 1){
                    mTextContent ="0"+mTextContent;
                }
                postInvalidate();
            }
        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //重新计算宽高
        int width = 0;
        int height = 0;

        //从MeasureSpec中获取大小和模式

        //宽
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);

        switch (widthmode){
            case MeasureSpec.EXACTLY://如果有精确的值 则宽得值就是精确的值
                width = getPaddingLeft()+getPaddingRight()+ widthsize;
                break;
            case MeasureSpec.AT_MOST://wrap_content模式下 宽为字体边界宽度
                width = getPaddingLeft()+getPaddingRight()+mBound.width();
                break;
        }
        //高 取值同width逻辑一致
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);

        switch (heightmode){
            case MeasureSpec.EXACTLY:
                height = getPaddingBottom()+getPaddingTop()+heightsize;
                break;
            case MeasureSpec.AT_MOST:
                height = getPaddingBottom()+getPaddingTop()+mBound.height();
                break;
        }

        setMeasuredDimension(width,height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);

        mPaint.setColor(mTextColor);
        canvas.drawText(mTextContent ,getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2,mPaint);

    }

}
