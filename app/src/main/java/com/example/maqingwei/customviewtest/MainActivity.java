package com.example.maqingwei.customviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
        mTopView3.setTextView("","主页","",getDrawable(R.drawable.back_img),null);
        
        ClickButton btn = (ClickButton) findViewById(R.id.click_btn);
        btn.setOnClick(new ClickButton.OnClick() {
            @Override
            public void clickOnce() {

                Toast.makeText(MainActivity.this, "切换了蓝色背景", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickTwice() {
                Toast.makeText(MainActivity.this, "切换了粉色背景", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
