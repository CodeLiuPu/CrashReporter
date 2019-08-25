package com.update.crashreporter.utils;

import android.Manifest;
import android.os.Build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

    /**
     * 向文件中写入String数据
     */
    public static void saveString2File(String content) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionUtils.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                filePath = GlobalContext.getApp().getExternalFilesDir("Crash").getAbsolutePath() + File.separator + fileName;
            }
        }

        // 创建文件
        File file = new File(filePath);
        if (!file.exists()) {
            File dir = new File(file.getParent());
            boolean mkdirs = dir.mkdirs();
            try {
                boolean newFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 向文件中写数据
        if (file.exists()) {
            try (FileOutputStream os = new FileOutputStream(file)) {
                os.write(content.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
