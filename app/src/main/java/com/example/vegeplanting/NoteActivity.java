package com.example.vegeplanting;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class NoteActivity extends AppCompatActivity {
    private Toolbar toolbarNote;
    private TextView dateTodayTxt;

    private String dateToday;
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        toolbarNote = findViewById(R.id.toolbarNote);
        dateTodayTxt = findViewById(R.id.dateTodayTxt);

//TOOLBAR BACK
        toolbarNote.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteActivity.this.onBackPressed();
            }
        });

//GET CURRENT DATE
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        dateToday = simpleDateFormat.format(calendar.getTime());

//SET CURRENT DATE TO TEXT VIEW
        dateTodayTxt.setText(dateToday);
    }
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
}