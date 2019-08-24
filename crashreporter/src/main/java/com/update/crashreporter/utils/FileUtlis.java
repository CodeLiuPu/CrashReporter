package com.update.crashreporter.utils;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class FileUtlis {
    public static void saveEx2File(){
        new Throwable().getStackTrace();
    }
}
