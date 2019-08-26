package com.update.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    /**
     * 测试 crash 逻辑
     */
    public void test() {
        Object o = null;
        o.toString();
    }
}
