package com.update.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.update.crashreporter.CrashReporter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        test();
        testCatched();
    }

    /**
     * 测试 crash 逻辑
     */
    public void test() {
        Object o = null;
        o.toString();
    }

    /**
     * 测试 crash catched 逻辑
     */
    public void testCatched() {
        Object o = null;
        try{
            o.toString();

        } catch (Exception e){
            CrashReporter.handleCatchedException(e);
        }
    }
}
