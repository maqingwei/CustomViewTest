package com.example.maqingwei.customviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private  TopView mTopView1,mTopView2,mTopView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopView1 = (TopView) findViewById(R.id.mytopview);
        mTopView1.setTextView("返回","个人中心","注册",null,null);

        mTopView2 = (TopView) findViewById(R.id.mytopview1);
        mTopView2.setTextView("","主页","",null,null);

        mTopView3 = (TopView) findViewById(R.id.mytopview2);
        mTopView3.setTextView("","注册","",getDrawable(R.drawable.back_img),null);

    }
}
