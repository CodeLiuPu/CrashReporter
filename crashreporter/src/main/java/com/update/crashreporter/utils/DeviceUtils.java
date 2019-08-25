package com.update.crashreporter.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class DeviceUtils {

    private DeviceUtils() {
    }

    /**
     * 获取当前日期
     * 日期格式 - "yyyy-MM-dd HH:mm:ss"
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentTime() {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String time = sdf.format(new Date(currentTime));
        return time;
    }

    /**
     * 获取系统版本字符串
     * 例如 : Android_4.1.2
     */
    public static String getSystemVersion() {
        return "Android_" + Build.VERSION.RELEASE;
    }

    /**
     * 获取 SDK版本
     */
    public static String getSDKVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    /**
     * 获取 手机品牌
     */
    public static String getPhoneBrand() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取 手机机型
     */
    public static String getPhoneType() {
        return Build.MODEL;
    }

    /**
     * 获取 CPU类型
     */
    public static String getCPUType() {
        return Build.CPU_ABI;
    }

    /**
     * 获取设备 deviceId
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getDeviceId() {
        String deviceId = "00000000000000";

        if (PermissionUtils.noPermission(Manifest.permission.READ_PHONE_STATE)) {
            return deviceId;
        }

        TelephonyManager tm = (TelephonyManager) GlobalContext.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        deviceId = tm.getDeviceId();
        return deviceId;
    }

    /**
     * 获取设备 MEID号
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getMEID() {
        String MEID = "00000000000000";

        if (PermissionUtils.noPermission(Manifest.permission.READ_PHONE_STATE)) {
            return MEID;
        }

        TelephonyManager tm = (TelephonyManager) GlobalContext.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            MEID = tm.getMeid();
        } else {
            MEID = tm.getDeviceId();
        }
        return MEID;
    }

    /**
     * 获取设备 IMEI号
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEI() {
        String IMEI = "00000000000000";

        if (PermissionUtils.noPermission(Manifest.permission.READ_PHONE_STATE)) {
            return IMEI;
        }

        TelephonyManager tm = (TelephonyManager) GlobalContext.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            IMEI = tm.getImei();
        } else {
            IMEI = tm.getDeviceId();
        }
        return IMEI;
    }

    /**
     * 获取机身 Rom内存 总大小
     */
    private static String getRomTotalSize() {
        File path = Environment.getDataDirectory();
        StatFs statFs = new StatFs(path.getPath());
        long blockSize = statFs.getBlockSize();
        long totalBlocks = statFs.getBlockCount();
        return Formatter.formatFileSize(GlobalContext.getApp(), blockSize * totalBlocks);
    }

    /**
     * 获取 mac 地址
     * 通过 WifiManager 获取
     */
    @SuppressLint("HardwareIds")
    private static String getMac() {

        WifiManager wifiManager = (WifiManager) GlobalContext.getApp()
                .getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        if (wifiManager == null) {
            return "";
        }
        return wifiManager.getConnectionInfo().getMacAddress();
    }
}
