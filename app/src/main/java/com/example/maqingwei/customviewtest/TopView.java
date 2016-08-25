package com.example.maqingwei.customviewtest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by maqingwei
 * Date on 16/8/25 下午3:28
 *
 * @Description: 组合View TopBar 可以自定义设置显示内容
 */
public class TopView extends FrameLayout implements View.OnClickListener{

    private TextView  mLeft,mCenter,mRight;
    private Context mContext;

    public TopView(Context context) {
        super(context);
        this.mContext = context;
    }

    public TopView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.topview,this);

        mLeft = (TextView)findViewById(R.id.tv_left);
        mCenter = (TextView)findViewById(R.id.tv_center_title);
        mRight = (TextView)findViewById(R.id.tv_right);

        mLeft.setOnClickListener(this);
        mCenter.setOnClickListener(this);
        mRight.setOnClickListener(this);

    }

    //设置左边按钮 文字 图片 显示与否
    public void setLeft(String str, Drawable drawable){

        if (str.equals("") && drawable == null){
            mLeft.setVisibility(GONE);
        }else{
            mLeft.setVisibility(VISIBLE);
            mLeft.setText(str);
        }
        if (drawable != null){
            mLeft.setVisibility(VISIBLE);
            mLeft.setBackground(drawable);
        }

    }

    //设置表标题内容
    public void setCenter(String str){
        if (str.equals("")){
            mCenter.setVisibility(GONE);
        }else{
            mCenter.setVisibility(VISIBLE);
            mCenter.setText(str);
        }
    }

    //设置右边按钮 文字 图片 显示与否
    public void setRight(String str,Drawable drawable){
        if (str.equals("") && drawable == null){
            mRight.setVisibility(GONE);
        }else{
            mRight.setVisibility(VISIBLE);
            mRight.setText(str);
        }
        if (drawable != null){
            mRight.setVisibility(VISIBLE);
            mRight.setBackground(drawable);
        }
    }

    public  void setTextView(String left,String center,String right,Drawable leftdraw,Drawable rightdraw){
        setLeft(left,leftdraw);
        setCenter(center);
        setRight(right,rightdraw);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.tv_left:
                Toast.makeText(mContext,"点击了左按钮",Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv_right:
                Toast.makeText(mContext,"点击了右按钮",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
