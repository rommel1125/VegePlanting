package com.example.vegeplanting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDataActivity extends AppCompatActivity {
private Toolbar toolbar;
private TextView vegeName,textDescription;
private ImageView imageView;
private Button tutorialButton,startPlanting;
private DatabaseHelper databaseHelper;

public static final String EXTRA_URI = "com.example.vegetableplantingtutorial.EXTRA_URI";
public static final String EXTRA_VEGETABLE_ID = "com.example.vegetableplantingtutorial.EXTRA_VEGETABLE_ID";


private String name,des,number;
private int image;
    private String videoUrl;
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
        tutorialButton = findViewById(R.id.tutorialButton);
        startPlanting = findViewById(R.id.startPlanting);

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
        number = intent.getStringExtra("id23");

        VegetableController con = new VegetableController(ListDataActivity.this);
        Vegetables vegetable = con.getVegetableById(number);

        Resources resources = getResources();
        final int resourceId = resources.getIdentifier(vegetable.getImageName(), "drawable", getPackageName());
        imageView.setImageResource(resourceId);

//CALLING Description Method
        Description();

//ATTACH INTENT
        vegeName.setText(name);
        textDescription.setText(des);
        toolbar.setTitle(vegeName.getText().toString());

//TUTORIAL BUTTON
        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTutorialActivity();
            }
        });
    }

    private void Description(){
        Cursor cursor = databaseHelper.getDescription(name);
        while(cursor.moveToNext()){
            des = cursor.getString(2);
        }
    }

    public void openTutorialActivity() {

        String uri = this.videoUrl;

        if(hasConnection()) {

            Intent onlineIntent = new Intent(this, OnlineTutorialActivity.class);
            onlineIntent.putExtra(EXTRA_URI, uri);

            Intent offlineIntent = new Intent(this, OfflineTutorialActivity.class);
            offlineIntent.putExtra(EXTRA_VEGETABLE_ID, number);

            AlertDialog.Builder builder = new AlertDialog.Builder(ListDataActivity.this);
            builder.setMessage("Do you want to proceed to video tutorial or the offline documents")
                    .setCancelable(true)
                    .setPositiveButton("Video", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(onlineIntent);
                        }
                    })
                    .setNegativeButton("Document", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(offlineIntent);
                        }
                    })
                    .show();

        }   else {
            showOptionDialog();
        }

    }

    public boolean hasConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ListDataActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {
            return true;
        } else {
            return false;
        }
    }
    public void showOptionDialog() {

        Intent intent = new Intent(this, OfflineTutorialActivity.class);
        intent.putExtra(EXTRA_VEGETABLE_ID, number);

        AlertDialog.Builder builder = new AlertDialog.Builder(ListDataActivity.this);
        builder.setMessage("You have no internet connection, Proceed to Offline Tutorial Mode instead ?")
                .setCancelable(true)
                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                    }
                })
                .show();

    }
}