package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

import org.jetbrains.annotations.Nullable;

public class AppIntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_app_intro);
        Intro();
        addSlide(AppIntroFragment.newInstance("Vegetable Planting Tutorial","This is some of common vegetable in the philippines that you need to plant and give the vitamins you need in your body.",R.drawable.front, ContextCompat.getColor(getApplicationContext(), R.color.bg_green)));
        addSlide(AppIntroFragment.newInstance("Why this app?","This application guide you to plant a vegetable . Plus its easy and user friendly User interface.",R.drawable.whythisapp,ContextCompat.getColor(getApplicationContext(), R.color.bg_green)));
        addSlide(AppIntroFragment.newInstance("How does it work?","Vegetable planting tutorial application show the documents or video tutorial to guide everyone of us. And this application works in offline mode and online mode",R.drawable.howdoesitwork,ContextCompat.getColor(getApplicationContext(), R.color.bg_green)));
        addSlide(AppIntroFragment.newInstance("Discover even more.","Add daily note to see the progress of your vegetable",R.drawable.notes,ContextCompat.getColor(getApplicationContext(), R.color.bg_green)));
        addSlide(AppIntroFragment.newInstance("Lets get started","now let's do planting of vegetable. You can use this application to discover how the vegetable grow.",R.drawable.lastpage,ContextCompat.getColor(getApplicationContext(), R.color.bg_green)));
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void Intro(){
        SharedPreferences preferences = getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall","");

        if (FirstTime.equals("Yes")){
            Intent intent = new Intent(AppIntroActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeInstall","Yes");
            editor.apply();
        }
    }
}
