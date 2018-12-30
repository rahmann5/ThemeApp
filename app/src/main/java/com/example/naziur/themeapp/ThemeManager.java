package com.example.naziur.themeapp;

import android.app.Activity;
import android.content.Intent;

public class ThemeManager {
    public final static int THEME_MATERIAL_LIGHT = 0;
    public final static int THEME_MATERIAL_DARK = 1;

    public static void changeToTheme(Activity activity) {
        activity.finish();
        activity.startActivity(new Intent(activity, MainActivity.class));
        activity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    public static void onActivityCreateSetTheme(Activity activity, int sTheme) {
        switch (sTheme) {
            default:
            case THEME_MATERIAL_LIGHT:
                activity.setTheme(R.style.Theme_Default_Light);
                break;
            case THEME_MATERIAL_DARK:
                activity.setTheme(R.style.Theme_Default_Dark);
                break;
        }
    }
}
