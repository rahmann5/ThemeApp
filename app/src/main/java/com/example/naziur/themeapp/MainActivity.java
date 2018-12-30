package com.example.naziur.themeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int chosenTheme = sharedPrefs.getInt(
                SettingsActivity.THEME_PREF_KEY,
                0);

        ThemeManager.onActivityCreateSetTheme(this, chosenTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSettingsPage(View view){
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

}
