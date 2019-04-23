package com.wangkm.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
* @author: created by wangkm
* @Time: 2019-04-23
* @Des：
* @Email: kangmao.wang@foxmail.com
*/
public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.canvas_operation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CircleOperationActivity.class));
            }
        });


        findViewById(R.id.canvas_circle_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CustomCircleActivity.class));
            }
        });

        findViewById(R.id.clip_rgn_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ClipRgnActivity.class));
            }
        });

        findViewById(R.id.custom_view_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CustomViewActivity.class));
            }
        });
    }
}
