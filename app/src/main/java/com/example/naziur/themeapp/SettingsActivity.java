package com.example.naziur.themeapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {
    private Spinner spinner;
    private boolean themeChanged;
    public static final String THEME_PREF_KEY = "Theme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int chosenTheme = sharedPrefs.getInt(
                SettingsActivity.THEME_PREF_KEY,
                0);

        ThemeManager.onActivityCreateSetTheme(this, chosenTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        spinner = (Spinner) findViewById(R.id.theme_spinner);
        themeChanged = false;
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.themes,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setSelection(sharedPref.getInt(THEME_PREF_KEY, 0));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            int count = 0;
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(count >0) {

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt(THEME_PREF_KEY, i);
                    editor.commit();
                    themeChanged = true;

                }
                count++;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(themeChanged) {
            ThemeManager.changeToTheme(SettingsActivity.this);
        }
    }
}
