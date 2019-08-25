package com.update.crashreporter.utils;

import android.app.ApplicationErrorReport;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class ExUtils {

    private ExUtils() {
    }

    // 打印当前栈信息
//        new Throwable().getStackTrace();

    public static String getExceptionMessage(Thread thread, Throwable ex) {

        if (ex == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("------------------").append("App Crash").append("------------------------").append("\n");

        sb.append("发生时间：").append(DeviceUtils.getCurrentTime()).append("\n");
//        sb.append("用户UserId：").append(AccountManager.getInstance().getUserId()).append("\n");
//        sb.append("用户手机号：").append(AccountManager.getInstance().getPhone()).append("\n");
        sb.append("APP版本：").append(AppUtils.getVersionName()).append("\n");
        sb.append("设备IMEI：").append(DeviceUtils.getIMEI()).append("\n");
        sb.append("系统版本：").append(DeviceUtils.getSystemVersion()).append("\n");
        sb.append("SDK版本：").append(DeviceUtils.getSDKVersion()).append("\n");
        sb.append("手机品牌").append(DeviceUtils.getPhoneBrand()).append("\n");
        sb.append("机型：").append(DeviceUtils.getPhoneType()).append("\n");
        sb.append("CPU类型：").append(DeviceUtils.getCPUType()).append("\n");
        sb.append("Thread：").append(thread.getName()).append("\n");
        sb.append("Error类型：").append(ex.getClass().getSimpleName()).append("\n");
        sb.append("Error信息：").append(ex.toString()).append("\n");

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ex.printStackTrace(new PrintStream(baos));
            sb.append("Error详情：").append(baos.toString()).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
