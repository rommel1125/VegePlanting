package com.example.vegeplanting;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<NoteModel> noteList;

    public NoteListAdapter(Context context, int layout, ArrayList<NoteModel> noteList) {
        this.context = context;
        this.layout = layout;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView noteDate,noteNote;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);
            holder.noteDate = row.findViewById(R.id.noteDate);
            holder.noteNote = row.findViewById(R.id.noteNote);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        NoteModel model = noteList.get(position);
        holder.noteDate.setText(model.getDateOfNote());
        holder.noteNote.setText(model.getNote());
        return row;
    }
}
