package com.example.vegeplanting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public ImageSlider imageSlider;
    String[] vegeName = {"EGGPLANT","TOMATO","OKRA","STRING BEANS","SQUASH","PARSLEY","WATER SPINACH","LETTUCE","BOTTLE GOURD","BITTER MELON"};
    int[] vegeImages = {R.drawable.eggplant,R.drawable.tomato,R.drawable.okra,R.drawable.stringbeans,R.drawable.squash,R.drawable.parsley,R.drawable.kangkong,R.drawable.lettuce,R.drawable.bottlegourd,R.drawable.bittermelon};
    String[] number = {"1","2","3","4","5","6","7","8","9","10"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        imageSlider = view.findViewById(R.id.image_slider);
        imageSlide();
        return view;
    }

    public void imageSlide(){
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.eggplant1,"Eggplant", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.tomato1,"Tomato", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.okra1,"Okra", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sitaw1,"String Beans", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.kalabasa1,"Squash", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.parsley1,"Parsley", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.kangkong1,"Water Spinach", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.lettuce1,"Lettuce", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.upo1,"Bottle gourd", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.ampalaya1,"Bitter Melon", ScaleTypes.FIT));

        imageSlider.setImageList(imageList,ScaleTypes.FIT);
        imageSlider.startSliding(2000);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Intent intent = new Intent(getActivity(),ListDataActivity.class);
                intent.putExtra("name",vegeName[i]);
                intent.putExtra("image",vegeImages[i]);
                intent.putExtra("id23",number[i]);
                startActivity(intent);
            }
        });
    }
}
