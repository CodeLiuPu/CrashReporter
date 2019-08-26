package com.update.crashreporter.utils.log;

import android.text.TextUtils;

public class LogConfig {
    String tag = "";
    boolean isDebug = false;

    public LogConfig(String tag, boolean isDebug) {
        if (!TextUtils.isEmpty(tag)) {
            this.tag = tag;
        }
        this.isDebug = isDebug;
    }
}