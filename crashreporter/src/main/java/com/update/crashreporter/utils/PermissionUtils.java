package com.update.crashreporter.utils;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.update.crashreporter.GlobalContext;

/**
 * @author : liupu
 * date    : 2019/8/24
 * desc    :
 */
public class PermissionUtils {

    private PermissionUtils() {
    }

    /**
     * 检查是否拥有 数组中所有的权限
     * 若其中有一个权限没有返回 false
     */
    public static boolean checkPermissions(String[] permissions) {
        for (String permission : permissions) {
            if (noPermission(permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查是否拥有该权限
     *
     * @return 是否 有 该权限
     */
    public static boolean checkPermission(@NonNull String permission) {
        boolean checkResult = false;
        checkResult = ActivityCompat.checkSelfPermission(GlobalContext.getApp(), permission)
                != PackageManager.PERMISSION_GRANTED;
        return checkResult;
    }


    /**
     * 检查是否没有该权限
     *
     * @return 是否 没有 该权限
     */
    public static boolean noPermission(@NonNull String permission) {
        return !checkPermission(permission);
    }

    /**
     * 检查是否 没有 数组中是所有权限
     *
     * @return 是否 没有 该权限
     */
    public static boolean noPermissions(String[] permissions) {
        for (String permission : permissions) {
            if (checkPermission(permission)) {
                return false;
            }
        }
        return true;
    }

}
