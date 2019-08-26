package com.update.crashreporter;

import com.update.crashreporter.utils.log.LogConfig;
import com.update.crashreporter.utils.log.LogUtil;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class CrashReporter {

    private CrashReporter() {
    }

    public static void init(CrashConfig crashConfig) {
        GlobalContext.init(crashConfig.getApp());
        LogUtil.setConfig(new LogConfig("Update Hello", crashConfig.isDebug()));
        new CrashHandler().init();
    }

    public static void handleCatchedException(Throwable ex) {
        CrashHandler.handleThreadException(ex);
    }

    public static void handleCatchedException(Thread thread, Throwable ex) {
        CrashHandler.handleThreadException(thread, ex);
    }
}
