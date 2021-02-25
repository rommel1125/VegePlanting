package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class OfflineTutorialActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private WormDotsIndicator wormDotsIndicator;
    private Toolbar actionbar;
    private String vegetableId;
    private SliderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_tutorial);

        actionbar = findViewById(R.id.actionbar);
        viewPager = findViewById(R.id.slider_view_pager);
        wormDotsIndicator = findViewById(R.id.worm_dots_indicator);
        Intent intent = getIntent();
        vegetableId = intent.getStringExtra(ListDataActivity.EXTRA_VEGETABLE_ID);

        actionbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OfflineTutorialActivity.this.onBackPressed();
            }
        });

        adapter = new SliderAdapter(this,vegetableId);
        viewPager.setAdapter(adapter);
        wormDotsIndicator.setViewPager(viewPager);
    }
}