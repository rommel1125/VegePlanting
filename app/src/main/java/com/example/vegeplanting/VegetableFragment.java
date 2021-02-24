package com.example.vegeplanting;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VegetableFragment extends Fragment {
    private ListView listView;
    String[] vegeName = {"EGGPLANT","TOMATO","OKRA","STRING BEANS","SQUASH","PARSLEY","WATER SPINACH","LETTUCE","BOTTLE GOURD","BITTER MELON"};
    int[] vegeImages = {R.drawable.eggplant,R.drawable.tomato,R.drawable.okra,R.drawable.stringbeans,R.drawable.squash,R.drawable.parsley,R.drawable.kangkong,R.drawable.lettuce,R.drawable.bottlegourd,R.drawable.bittermelon};
    String[] number = {"1","2","3","4","5","6","7","8","9","10"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vegetable,container,false);


        listView = view.findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ListDataActivity.class);
                intent.putExtra("name",vegeName[position]);
                intent.putExtra("image",vegeImages[position]);
                intent.putExtra("id23",number[position]);
                startActivity(intent);
            }
        });

        return view;
    }
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {

            return vegeImages.length;
        }

        @Override
        public Object getItem(int i) {

            return null;
        }

        @Override
        public long getItemId(int i) {

            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name = view1.findViewById(R.id.vegetable_name);
            ImageView image = view1.findViewById(R.id.vegetable_images);

            name.setText(vegeName[i]);
            image.setImageResource(vegeImages[i]);

            return view1;
        }

    }
}
