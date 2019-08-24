package com.update.crashreporter;

import android.app.Application;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class CrashConfig {
    private Application application;
    private boolean isDebug;

    private CrashConfig(Builder builder) {
        this.application = builder.application;
        this.isDebug = builder.isDebug;
    }

    public Application getApp() {
        return application;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public static class Builder {
        Application application;
        boolean isDebug = false;

        public Builder setApp(Application application) {
            this.application = application;
            return this;
        }

        public Builder setDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        public CrashConfig build() {
            if (application == null) {
                throw new IllegalArgumentException("u should setApp first");
            }
            return new CrashConfig(this);
        }
    }
}
