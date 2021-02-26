package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class PlanItemActivity extends AppCompatActivity {

    private TextView vegetableName,dateTxt,seedCount;
    private Button viewCalendar;
    private Toolbar toolbar2;
    private ImageView imagePlan;

    private String name;
    private String date;
    private String count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_item);

//FIND VIEW BY ID
        toolbar2 = findViewById(R.id.toolbar2);
        imagePlan = findViewById(R.id.imagePlan);
        vegetableName = findViewById(R.id.vegetableName);
        dateTxt = findViewById(R.id.dateTxt);
        viewCalendar = findViewById(R.id.viewCalendar);
        seedCount = findViewById(R.id.seedCount);

//TOOLBAR BACK
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanItemActivity.this.onBackPressed();
            }
        });

//GET INTENT
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        date = intent.getStringExtra("date");
        count = intent.getStringExtra("count");

//TOOLBAR SET TITLE
        toolbar2.setTitle(name);

//PUT IN TEXT VIEW'S
        vegetableName.setText(name);
        dateTxt.setText(date);
        seedCount.setText(count);
        forImage();

//VIEW CALENDAR BUTTON
        viewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanItemActivity.this, CalendarActivity.class);
                startActivity(i);
            }
        });
    }

    private void forImage(){
        if (name.equals("EGGPLANT")){
            imagePlan.setImageResource(R.drawable.eggplanttry);
        }
        else if (name.equals("TOMATO")){
            imagePlan.setImageResource(R.drawable.tomatotry);
        }
        else if (name.equals("OKRA")){
            imagePlan.setImageResource(R.drawable.okratry);
        }
        else if (name.equals("STRING BEANS")){
            imagePlan.setImageResource(R.drawable.sitawtry);
        }
        else if (name.equals("SQUASH")){
            imagePlan.setImageResource(R.drawable.squashtry);
        }
        else if (name.equals("PARSLEY")){
            imagePlan.setImageResource(R.drawable.parsleytry);
        }
        else if (name.equals("WATER SPINACH")){
            imagePlan.setImageResource(R.drawable.waterspinachtry);
        }
        else if (name.equals("LETTUCE")){
            imagePlan.setImageResource(R.drawable.lettucetry);
        }
        else if (name.equals("BOTTLE GOURD")){
            imagePlan.setImageResource(R.drawable.bottlegourdtry);
        }
        else if (name.equals("BITTER MELON")){
            imagePlan.setImageResource(R.drawable.bittermelontry);
        }
    }
}