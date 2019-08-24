package com.update.test;

import android.app.Application;

import com.update.crashreporter.CrashConfig;
import com.update.crashreporter.CrashReporter;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReporter.init(
                new CrashConfig.Builder()
                        .setApp(this)
                        .setDebug(true)
                        .build());
    }
}
