package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.listener.CalenderDayClickListener;
import com.skyhope.eventcalenderlibrary.model.DayContainerModel;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    private Toolbar toolbarCalendar;
    private CalenderEvent calender_event;
    private CompactCalendarView compactcalendar_view;
    private TextView monthTxt;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        toolbarCalendar = findViewById(R.id.toolbarCalendar);
//        calender_event = findViewById(R.id.calender_event);
        compactcalendar_view = findViewById(R.id.compactcalendar_view);
        monthTxt = findViewById(R.id.monthTxt);

        toolbarCalendar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarActivity.this.onBackPressed();
            }
        });

        compactcalendar_view.setFirstDayOfWeek(Calendar.SUNDAY);
        compactcalendar_view.setUseThreeLetterAbbreviation(true);
        compactcalendar_view.setEventIndicatorStyle(CompactCalendarView.FILL_LARGE_INDICATOR);
        simpleDateFormat = new SimpleDateFormat("MMMM - yyyy", Locale.getDefault());

        compactcalendar_view.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                monthTxt.setText(simpleDateFormat.format(firstDayOfNewMonth));
            }
        });

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, 7);
//        Event event = new Event(calendar.getTimeInMillis(),"ASDASD", Color.BLACK);
//        Event event1 = new Event(calendar.getTimeInMillis(), "IBA to", Color.YELLOW);
//        calender_event.addEvent(event1);
//        calender_event.addEvent(event);
//        calender_event.requestFocus();


//        calender_event.initCalderItemClickCallback(new CalenderDayClickListener() {
//            @Override
//            public void onGetDay(DayContainerModel dayContainerModel) {
////CHECK IF DATE HAS EVENT
//                if (dayContainerModel.isHaveEvent()){
//                    Toast.makeText(CalendarActivity.this,dayContainerModel.getEvent().getEventText(),Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Log.d("asdasdasd", "WALA");
//                }
//
//            }
//        });

//        long epoch = System.currentTimeMillis()/1000;
//        String ll = String.valueOf(epoch);
//        Toast.makeText(CalendarActivity.this,ll,Toast.LENGTH_LONG).show();
    }
}