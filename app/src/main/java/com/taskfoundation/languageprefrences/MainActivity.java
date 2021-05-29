package com.taskfoundation.languageprefrences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        preferences = this.getSharedPreferences("com.taskfoundation.languageprefrences", Context.MODE_PRIVATE);

        String language = preferences.getString("language","Error");

        if (language.equals("Error")) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_btn_speak_now)
                    .setTitle("choose language")
                    .setMessage("which language would you like to choose?")
                    .setPositiveButton("English", (dialog, which) -> setLanguage("English"))
                    .setNegativeButton("Arabic", (dialog, which) -> setLanguage("Arabic"))
                    .show();
        }else{
            textView.setText(language);
        }
    }

    public void setLanguage(String language) {
        preferences.edit().putString("language",language).apply();

        textView.setText(language);
    }
}