package com.update.crashreporter;

import android.app.Application;

import com.update.crashreporter.utils.GlobalContext;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class CrashReporter {
    private static final CrashHandler mCrashHelper = new CrashHandler();

    public static void init(Application application) {
        GlobalContext.init(application);
    }
}
