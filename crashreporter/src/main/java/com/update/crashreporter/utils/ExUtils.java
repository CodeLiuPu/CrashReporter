package com.update.crashreporter.utils;

import android.util.Log;

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

        if (ex == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append("------------------").append("AppCrash Start").append("------------------").append("\n");
        sb.append("app名称: ").append(AppUtils.getAppName()).append("\n");
        sb.append("app版本: ").append(AppUtils.getVersionName()).append("\n");
        sb.append("发生时间: ").append(DeviceUtils.getCurrentTime()).append("\n");
        sb.append("设备IMEI: ").append(DeviceUtils.getIMEI()).append("\n");
        sb.append("系统版本: ").append(DeviceUtils.getSystemVersion()).append("\n");
        sb.append("SDK版本: ").append(DeviceUtils.getSDKVersion()).append("\n");
        sb.append("手机品牌: ").append(DeviceUtils.getPhoneBrand()).append("\n");
        sb.append("机型: ").append(DeviceUtils.getPhoneType()).append("\n");
        sb.append("CPU类型: ").append(DeviceUtils.getCPUType()).append("\n");
        sb.append("Thread: ").append(thread.getName()).append("\n");
        sb.append("Error类型: ").append(ex.getClass().getSimpleName()).append("\n");
        sb.append("Error详情: ").append(Log.getStackTraceString(ex)).append("\n");
        sb.append("------------------").append("AppCrash End").append("------------------").append("\n");
        return sb.toString();
    }
}
