package com.update.crashreporter;

import com.update.crashreporter.utils.ExUtils;
import com.update.crashreporter.utils.FileUtlis;
import com.update.crashreporter.utils.log.LogUtil;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    public void init() {
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable ex) {
        if (ex == null) {
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(t, ex);
            } else {
                exit();
            }
        } else {
            handleThreadException(t, ex);
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(t, ex);
            }
        }
    }

    /**
     * 处理线程异常
     */
    public static void handleThreadException(Throwable ex) {
        handleThreadException(Thread.currentThread(), ex);
    }

    /**
     * 处理线程异常
     */
    public static void handleThreadException(Thread thread, Throwable ex) {
        String exMsg = ExUtils.getExceptionMessage(thread, ex);
        LogUtil.e(exMsg);
        FileUtlis.saveString2File(exMsg);
    }

    private void exit() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}
