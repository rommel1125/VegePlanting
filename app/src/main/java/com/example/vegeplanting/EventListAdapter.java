package com.example.vegeplanting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<EventModel> eventList;

    public EventListAdapter(Context context, int layout, ArrayList<EventModel> eventList) {
        this.context = context;
        this.layout = layout;
        this.eventList = eventList;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView eventDate,eventDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);
            holder.eventDate = row.findViewById(R.id.eventDate);
            holder.eventDescription = row.findViewById(R.id.eventDescription);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        EventModel model = eventList.get(position);
        holder.eventDate.setText(model.getHarvestDate());
        holder.eventDescription.setText(model.getDescription());

        return row;
    }
}
