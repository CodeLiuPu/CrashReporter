package com.update.crashreporter;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class CrashReporter {

    private static final CrashHandler mCrashHelper = new CrashHandler();

    private CrashReporter() {
    }

    public static void init(CrashConfig crashConfig) {
        GlobalContext.init(crashConfig.getApp());
    }
}
