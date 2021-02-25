package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;

import org.jetbrains.annotations.Nullable;

public class MyAppIntro extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        addSlide(AppIntroFragment.newInstance("Hey","This is inside Android",R.drawable.eggplant1, Color.rgb(61,220,132)));
        addSlide(AppIntroFragment.newInstance("Hey","This is inside Android",R.drawable.tomato1, Color.rgb(61,220,132)));
        addSlide(AppIntroFragment.newInstance("Hey","This is inside Android",R.drawable.ampalaya1, Color.rgb(61,220,132)));
        addSlide(AppIntroFragment.newInstance("Hey","This is inside Android",R.drawable.kalabasa1, Color.rgb(61,220,132)));
        

    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        finish();
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        finish();
    }
}