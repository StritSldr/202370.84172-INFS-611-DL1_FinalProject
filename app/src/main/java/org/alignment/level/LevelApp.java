package org.alignment.level;

import android.app.Application;

import org.alignment.level.util.PreferenceHelper;

public class LevelApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceHelper.initPrefs(this);
    }
}
