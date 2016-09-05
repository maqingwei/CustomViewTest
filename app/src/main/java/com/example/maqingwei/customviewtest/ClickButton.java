package com.example.maqingwei.customviewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by maqingwei
 * Date on 16/9/5 上午11:10
 *
 * @Description: 自定义点击按钮 切换背景色
 */
public class ClickButton extends Button {

    private int flag = 0;//0表示默认背景 1表示改变后的背景

    public ClickButton(Context context) {
        super(context);

    }

    public ClickButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        //设置一个默认背景
        ClickButton.this.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0){//如果未改变过 则设置改变后的背景
                ClickButton.this.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                   if (mClick != null){
                       mClick.clickOnce();
                   }
                flag = 1;
                }else{
                    ClickButton.this.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    if (mClick != null){
                        mClick.clickTwice();
                    }
                 flag =0;
                }
            }
        });

    }

    //点击事件回调
    private OnClick mClick;

    public interface OnClick{
        void clickOnce();
        void clickTwice();
    }

    public void setOnClick(OnClick click){
        mClick = click;
    }

}
