package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDataActivity extends AppCompatActivity {
private Toolbar toolbar;
private TextView vegeName,textDescription;
private ImageView imageView;
private DatabaseHelper databaseHelper;

private String name,des;
private int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        databaseHelper = new DatabaseHelper(this);

//FIND VIEW BY ID
        toolbar = findViewById(R.id.toolbar1);
        vegeName = findViewById(R.id.vegeName);
        imageView = findViewById(R.id.imageView);
        textDescription = findViewById(R.id.textDescription);

//TOOLBAR BACK
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListDataActivity.this.onBackPressed();
            }
        });

//GET INTENT
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        image = intent.getIntExtra("image",0);

//CALLING Description Method
        Description();

//ATTACH INTENT
        vegeName.setText(name);
        imageView.setImageResource(image);
        textDescription.setText(des);
        toolbar.setTitle(vegeName.getText().toString());
    }

    private void Description(){
        Cursor cursor = databaseHelper.getDescription(name);
        while(cursor.moveToNext()){
            des = cursor.getString(2);
        }
    }
}