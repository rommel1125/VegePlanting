package com.example.vegeplanting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.listener.CalenderDayClickListener;
import com.skyhope.eventcalenderlibrary.model.DayContainerModel;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    private Toolbar toolbarCalendar;
    private Calendar calendar;
    private Date date;
    private CalendarView calendarView;
    private DatabaseHelper databaseHelper;
    private SimpleDateFormat simpleDateFormat;
    private String harvestDate = "";

    private ListView eventListView;
    private ArrayList<EventModel> mList;
    private EventListAdapter mAdapter = null;

    private int vegeid;

    private static final String DATE_FORMAT = "MM/dd/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        databaseHelper = new DatabaseHelper(this);

        toolbarCalendar = findViewById(R.id.toolbarCalendar);
        calendarView = findViewById(R.id.calendarView);
        eventListView = findViewById(R.id.eventListView);

//GET INTENT
        Intent intent = getIntent();
        vegeid = intent.getIntExtra("vegeid",0);

//LIST VIEW
        mList = new ArrayList<>();
        mAdapter = new EventListAdapter(this,R.layout.event_row,mList);
        eventListView.setAdapter(mAdapter);

        toolbarCalendar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarActivity.this.onBackPressed();
            }
        });


        simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        addEvent();
        if (harvestDate.equals("")) {
            Toast.makeText(getApplicationContext(),"No events", Toast.LENGTH_LONG).show();
        }
        else {
            try {
                date = simpleDateFormat.parse(harvestDate);
                calendar = Calendar.getInstance();
                calendar.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<EventDay> event = new ArrayList<>();
            event.add(new EventDay(calendar, R.drawable.ic_event));
            calendarView.setEvents(event);
        }
        calendarEvent();

//        Calendar calendar = Calendar.getInstance();
//        try {
//            calendarView.setDate(calendar);
//        } catch (OutOfDateRangeException e) {
//            e.printStackTrace();
//        }
//        List<EventDay> event = new ArrayList<>();
//        event.add(new EventDay(calendar, R.drawable.ic_event));
//        calendarView.setEvents(event);
        eventListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final CharSequence[] items = {"Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(CalendarActivity.this);
                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){
                            Cursor c = databaseHelper.getCalendarEvent("SELECT * FROM CALENDAR_TABLE");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while(c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDeleteDialog(arrID.get(position));
                            databaseHelper.close();
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(@NotNull EventDay eventDay) {
//                if (eventDay != null){
//
//                }
                Calendar clickedDayCalendar = eventDay.getCalendar();
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                Toast.makeText(getApplicationContext(),sdf.format(clickedDayCalendar.getTime())+" ", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showDeleteDialog(int idEvent) {
        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(CalendarActivity.this);
        dialogDelete.setTitle("Warning !!");
        dialogDelete.setMessage("Are you sure to delete ?");
        dialogDelete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<EventDay> event = new ArrayList<>();
                calendarView.setEvents(event);
                try {
                    databaseHelper.deleteEvent(idEvent,vegeid);
                    Toast.makeText(getApplicationContext(),"DELETE", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Log.e("Error",e.getMessage());
                }
                calendarEvent();
            }
        });
        dialogDelete.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    public void calendarEvent(){
        Cursor cursor = databaseHelper.getCalendarEvent("SELECT * FROM CALENDAR_TABLE WHERE VEGEID = "+vegeid);
        mList.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String datePlanted = cursor.getString(1);
            String harvestDate = cursor.getString(2);
            int vegeID = cursor.getInt(3);
            String description = cursor.getString(4);

            mList.add(new EventModel(id,datePlanted,harvestDate,vegeID,description));
        }
        mAdapter.notifyDataSetChanged();
        databaseHelper.close();
    }
    public void addEvent(){
        Cursor cursor = databaseHelper.getCalendarEvent("SELECT * FROM CALENDAR_TABLE WHERE VEGEID = "+vegeid);
        while (cursor.moveToNext()){
            harvestDate = cursor.getString(2);
        }
    }
}