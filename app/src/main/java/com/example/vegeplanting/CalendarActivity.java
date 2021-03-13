package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    private Toolbar toolbarCalendar;
    private CalenderEvent calender_event;
    private CompactCalendarView compactcalendar_view;
    private TextView monthTxt;
    private CalendarView calendarView;
    SimpleDateFormat simpleDateFormat;
    DateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        toolbarCalendar = findViewById(R.id.toolbarCalendar);
//        calender_event = findViewById(R.id.calender_event);
//        compactcalendar_view = findViewById(R.id.compactcalendar_view);
//        monthTxt = findViewById(R.id.monthTxt);
        calendarView = findViewById(R.id.calendarView);

        toolbarCalendar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarActivity.this.onBackPressed();
            }
        });

        Calendar calendar = Calendar.getInstance();
        try {
            calendarView.setDate(calendar);
        } catch (OutOfDateRangeException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.DATE, 5);
        List<EventDay> event = new ArrayList<>();
        event.add(new EventDay(calendar, R.drawable.ic_event));
        calendarView.setEvents(event);


        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(@NotNull EventDay eventDay) {
//                if (eventDay != null){
//
//                }
                Calendar clickedDayCalendar = eventDay.getCalendar();
                SimpleDateFormat sdf = new SimpleDateFormat(PlanItemActivity.DATE_FORMAT);
                Toast.makeText(getApplicationContext(),sdf.format(clickedDayCalendar.getTime())+" ", Toast.LENGTH_LONG).show();
            }
        });


//        compactcalendar_view.setFirstDayOfWeek(Calendar.SUNDAY);
//        compactcalendar_view.setUseThreeLetterAbbreviation(true);
//        compactcalendar_view.shouldDrawIndicatorsBelowSelectedDays(true);
//        simpleDateFormat = new SimpleDateFormat("MMMM - yyyy", Locale.getDefault());
//        dateFormat = new SimpleDateFormat("MMMM - yyyy");
//        Date date = new Date();
//        monthTxt.setText(dateFormat.format(date));
//
//        Event ev1 = new Event(Color.YELLOW, 1615013675000L, "SAMPLE");
//        compactcalendar_view.addEvent(ev1);
//        Event ev2 = new Event(Color.BLUE, 1615100075000L, "EXAMPLE");
//        compactcalendar_view.addEvent(ev2);
//
//
//        compactcalendar_view.setListener(new CompactCalendarView.CompactCalendarViewListener() {
//            @Override
//            public void onDayClick(Date dateClicked) {
//                List<Event> events = compactcalendar_view.getEvents(dateClicked);
//                if (compactcalendar_view.getEvents(dateClicked).get(0).getData().equals("")){
//                    Log.d("TAGS","WALANG LAMAN");
//                }
//                else {
//                    Log.d("TAGS", "Date clicked: " + dateClicked + " with events " + compactcalendar_view.getEvents(dateClicked).get(0).getData().toString());
//                }
//            }
//
//            @Override
//            public void onMonthScroll(Date firstDayOfNewMonth) {
//                monthTxt.setText(simpleDateFormat.format(firstDayOfNewMonth));
//            }
//        });

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