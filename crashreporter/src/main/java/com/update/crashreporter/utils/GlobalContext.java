package com.update.crashreporter.utils;

import android.app.Application;
import android.support.annotation.NonNull;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class GlobalContext {

    private static Application sApplication;

    private GlobalContext() {
    }

    public static void init(@NonNull final Application app) {
        if (sApplication == null) {
            GlobalContext.sApplication = app;
        }
    }

    public static Application getApp() {
        return GlobalContext.sApplication;
    }
}
