package com.update.crashreporter.utils;

import android.Manifest;
import android.os.Build;

import com.update.crashreporter.GlobalContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class FileUtlis {


    private FileUtlis() {
    }

    /**
     * 向文件中写入String数据
     * 使用默认的文件path 和 name
     */
    public static void saveString2File(String content) {
        String name = AppUtils.getAppName() + "_" + DeviceUtils.getCurrentTime() + ".log";
        String path = GlobalContext.getApp().getFilesDir() + File.separator + "Crash";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionUtils.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                path = GlobalContext.getApp().getExternalFilesDir("Crash").getAbsolutePath();
            }
        }
        saveString2File(path, name, content);
    }

    /**
     * 向文件中写入String数据
     * 指定文件 path
     * 指定文件 name
     */
    public static void saveString2File(String path, String name, String content) {
        // 创建文件
        String filePath = path + File.separator + name;
        File file = new File(filePath);
        if (!file.exists()) {
            File dir = new File(file.getParent());
            dir.mkdirs();
            try {
                file.createNewFile();
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
