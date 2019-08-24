package com.update.crashreporter.utils;

import android.os.Build;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class ExUtils {

    private ExUtils() {
    }

    public static String getExceptionMessage(Thread thread, Throwable ex) {

        if (ex == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("------------------").append("App Crash").append("------------------------").append("\n");

        long currentTime = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(currentTime));
        stringBuilder.append("发生时间：").append(time).append("\n");
//        stringBuilder.append("用户UserId：").append(AccountManager.getInstance().getUserId()).append("\n");
//        stringBuilder.append("用户手机号：").append(AccountManager.getInstance().getPhone()).append("\n");
//        stringBuilder.append("APP版本：").append(AppUtils.getVersionName()).append("\n");
//        stringBuilder.append("设备IMEI：").append(AppUtils.getIMEI()).append("\n");
        stringBuilder.append("系统版本：").append("Android" + Build.VERSION.RELEASE).append("\n");
        stringBuilder.append("SDK版本：").append(Build.VERSION.SDK_INT).append("\n");
        stringBuilder.append("手机品牌").append(Build.MANUFACTURER).append("\n");
        stringBuilder.append("机型：").append(Build.MODEL).append("\n");
        stringBuilder.append("CPU类型：").append(Build.CPU_ABI).append("\n");
        stringBuilder.append("Thread：").append(thread.getName()).append("\n");
        stringBuilder.append("Error类型：").append(ex.getClass().getSimpleName()).append("\n");
        stringBuilder.append("Error信息：").append(ex.toString()).append("\n");

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ex.printStackTrace(new PrintStream(baos));
            stringBuilder.append("Error详情：").append(baos.toString()).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
