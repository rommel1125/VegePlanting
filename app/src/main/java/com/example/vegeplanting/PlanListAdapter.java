package com.example.vegeplanting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Model> planList;

    public PlanListAdapter(Context context, int layout, ArrayList<Model> planList) {
        this.context = context;
        this.layout = layout;
        this.planList = planList;
    }

    @Override
    public int getCount() {
        return planList.size();
    }

    @Override
    public Object getItem(int position) {
        return planList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView vegeName,datePlanted;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);
            holder.vegeName = row.findViewById(R.id.planVegetableName);
            holder.datePlanted = row.findViewById(R.id.planDatePlanted);
            holder.imageView = row.findViewById(R.id.planImage);
            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();
        }
        Model model = planList.get(position);

        holder.vegeName.setText(model.getVegeName());
        holder.datePlanted.setText(model.getDatePlanted());

        byte[] planImage = model.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(planImage,0,planImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
