package com.update.crashreporter;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable ex) {

    }

    /**
     * 处理子线程异常
     */
    private void handleThreadException(Thread thread, Throwable ex) {
//        String exceptionMessage = getExceptionMessage(thread, ex);
//        save2File(exceptionMessage);
//        LogUtils.e(TAG, exceptionMessage);
//        exit();
    }


    public void exit() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
