package com.update.crashreporter.utils;

import android.util.Log;

import java.io.File;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class FileUtlis {

    private static String fileName = AppUtils.getAppName() + "_" + DeviceUtils.getCurrentTime() + ".log";
    private static String filePath = GlobalContext.getApp().getFilesDir() + File.separator + "Crash" + File.separator + fileName;


    private FileUtlis() {
    }

    public static void saveEx2File() {
    }
}
