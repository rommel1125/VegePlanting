package com.example.vegeplanting;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;

public class PlanFragment extends Fragment {

    private ListView planListView;

    private DatabaseHelper databaseHelper;
    private String currentDate;

    private ArrayList<Model> list;
    private PlanListAdapter adapter = null;
    private ImageView imageView;

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plan, container, false);

        databaseHelper = new DatabaseHelper(getActivity());

        planListView = view.findViewById(R.id.planListView);
        list = new ArrayList<>();
        adapter = new PlanListAdapter(getActivity(),R.layout.list_item,list);
        planListView.setAdapter(adapter);

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        currentDate = sdf.format(calendar.getTime());

        Cursor cursor = databaseHelper.getPlan("SELECT * FROM PLAN_TABLE");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            String count = cursor.getString(4);

            list.add(new Model(id,name,date,image,count));
        }
        adapter.notifyDataSetChanged();
        if (list.size()==0){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EmptyFragment()).commit();
        }

        planListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final CharSequence[] items = {"View","Delete"};

                AlertDialog.Builder dialog  = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0){
                            //VIEW
                            Intent intent = new Intent(getActivity(),PlanItemActivity.class);
                            adapter = new PlanListAdapter(getActivity(),R.layout.list_item,list);
                            Model model = list.get(position);
                            String name = model.getVegeName().toString();
                            String date = model.getDatePlanted().toString();
                            String count = model.getVegeCount().toString();
                            int id = model.getId();
                            intent.putExtra("name",name);
                            intent.putExtra("date",date);
                            intent.putExtra("count",count);
                            intent.putExtra("id",id);
                            startActivity(intent);
                        }
                        if (which == 1){
                            //DELETE
                            Cursor c = databaseHelper.getPlan("SELECT ID FROM PLAN_TABLE");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while(c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

//LIST VIEW ITEM CLICK
        planListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),PlanItemActivity.class);
                adapter = new PlanListAdapter(getActivity(),R.layout.list_item,list);
                Model model = list.get(position);
                String name = model.getVegeName().toString();
                String date = model.getDatePlanted().toString();
                String count = model.getVegeCount().toString();
                int id1 = model.getId();
                intent.putExtra("name",name);
                intent.putExtra("date",date);
                intent.putExtra("count",count);
                intent.putExtra("id",id1);
                startActivity(intent);
            }
        });
        return view;
    }

    private void showDialogDelete(int idPlan) {
        AlertDialog.Builder dialogDelete  = new AlertDialog.Builder(getActivity());
        dialogDelete.setTitle("WARNING !");
        dialogDelete.setMessage("Are you sure to delete ?");
        dialogDelete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    databaseHelper.deletePlan(idPlan);
                    Toast.makeText(getActivity(),"Delete successfully",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Log.e("error",e.getMessage());
                }
                updatePlanList();
            }
        });
        dialogDelete.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void updatePlanList(){
        Cursor cursor = databaseHelper.getPlan("SELECT * FROM PLAN_TABLE");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            String count = cursor.getString(4);

            list.add(new Model(id,name,date,image,count));
        }
        adapter.notifyDataSetChanged();
        if (list.size()==0){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EmptyFragment()).commit();
        }
    }

//    public void forImage(){
//        if (planVegetableName.getText().toString().equals("EGGPLANT")){
//            planImage.setImageResource(R.drawable.eggplant);
//        }
//        else if (planVegetableName.getText().toString().equals("TOMATO")){
//            planImage.setImageResource(R.drawable.tomato);
//        }
//        else if (planVegetableName.getText().toString().equals("OKRA")){
//            planImage.setImageResource(R.drawable.okra);
//        }
//        else if (planVegetableName.getText().toString().equals("STRING BEANS")){
//            planImage.setImageResource(R.drawable.stringbeans);
//        }
//        else if (planVegetableName.getText().toString().equals("SQUASH")){
//            planImage.setImageResource(R.drawable.squash);
//        }
//        else if (planVegetableName.getText().toString().equals("PARSLEY")){
//            planImage.setImageResource(R.drawable.parsley);
//        }
//        else if (planVegetableName.getText().toString().equals("WATER SPINACH")){
//            planImage.setImageResource(R.drawable.kangkong);
//        }
//        else if (planVegetableName.getText().toString().equals("LETTUCE")){
//            planImage.setImageResource(R.drawable.lettuce);
//        }
//        else if (planVegetableName.getText().toString().equals("BOTTLE GOURD")){
//            planImage.setImageResource(R.drawable.bottlegourd);
//        }
//        else if (planVegetableName.getText().toString().equals("BITTER MELON")){
//            planImage.setImageResource(R.drawable.bittermelon);
//        }
//    }
}
