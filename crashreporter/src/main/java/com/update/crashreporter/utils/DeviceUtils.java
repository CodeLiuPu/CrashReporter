package com.update.crashreporter.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.ActivityCompat;
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

    /**
     * 获取当前日期
     * 日期格式 - "yyyy-MM-dd HH:mm:ss"
     */
    public static String getCurrentTime() {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date(currentTime));
        return time;
    }

    /**
     * 获取系统版本字符串。如4.1.2
     */
    public static String getSystemVersion() {
        return "Android_" + Build.VERSION.RELEASE;
    }

    /**
     * 获取设备的IMEI号
     */
    @SuppressLint("MissingPermission")
    public static String getIMEI(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            return "00000000000000";
        }
        TelephonyManager telephonyMgr = (TelephonyManager) GlobalContext.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyMgr.getDeviceId();
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
    private static String getMac() {

        WifiManager wifiManager = (WifiManager) GlobalContext.getApp()
                .getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        if (wifiManager == null) {
            return "";
        }
        String mac = wifiManager.getConnectionInfo().getMacAddress(); // mac地址
        return mac;
    }
}
