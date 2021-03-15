package com.example.vegeplanting;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class PlanItemActivity extends AppCompatActivity {

    private TextView vegetableName, dateTxt, seedCount,harvestTxt;
    private Button viewCalendar, addNote,addCalendar;
    private Toolbar toolbar2;
    private ImageView imagePlan;
    private ListView noteListView;
    private ArrayList<NoteModel> mList;
    private NoteListAdapter mAdapter = null;

    private String name;
    private String date;
    private String count;
    private String dateToday;
    private int id;
    private String description;
    private String harvestDate;
    private DatabaseHelper databaseHelper;

    public static final String DATE_FORMAT = "MM/dd/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_item);

        databaseHelper = new DatabaseHelper(this);


//FIND VIEW BY ID
        toolbar2 = findViewById(R.id.toolbar2);
        imagePlan = findViewById(R.id.imagePlan);
        vegetableName = findViewById(R.id.vegetableName);
        dateTxt = findViewById(R.id.dateTxt);
        viewCalendar = findViewById(R.id.viewCalendar);
        seedCount = findViewById(R.id.seedCount);
        addNote = findViewById(R.id.addNote);
        noteListView = findViewById(R.id.noteListView);
        addCalendar = findViewById(R.id.addCalendar);
        harvestTxt = findViewById(R.id.harvestTxt);

        mList = new ArrayList<>();
        mAdapter = new NoteListAdapter(this, R.layout.note_row, mList);
        noteListView.setAdapter(mAdapter);


//TOOLBAR BACK
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanItemActivity.this.onBackPressed();
            }
        });

//GET INTENT
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        date = intent.getStringExtra("date");
        count = intent.getStringExtra("count");
        id = intent.getIntExtra("id", 0);
        harvestDate = intent.getStringExtra("harvestDate");

        noteList();

//TOOLBAR SET TITLE
        toolbar2.setTitle(name);

//PUT IN TEXT VIEW'S
        vegetableName.setText(name);
        dateTxt.setText(date);
        harvestTxt.setText(harvestDate);
        seedCount.setText(count);
        forImage();

//VIEW CALENDAR BUTTON
        viewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanItemActivity.this, CalendarActivity.class);
                i.putExtra("vegeid",id);
                startActivity(i);
            }
        });

//ADD NOTE ACTIVITY
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(PlanItemActivity.this);
                dialog.setTitle("ADD NOTE");
                final View addnote = getLayoutInflater().inflate(R.layout.custom_addnote, null);
                dialog.setView(addnote);
                dialog.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("CANCEL", null);
                final AlertDialog dialog1 = dialog.create();
                dialog1.show();
                dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {
                        Boolean wantToCloseDialog = false;
                        EditText noteEdit = addnote.findViewById(R.id.noteEditText2);
                        TextView dateView = addnote.findViewById(R.id.dateTodayTxt2);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
                        Calendar calendar = Calendar.getInstance();
                        dateToday = simpleDateFormat.format(calendar.getTime());
                        dateView.setText(dateToday);

                        if (wantToCloseDialog) {
                            dialog1.dismiss();
                        } else {
                            if (TextUtils.isEmpty(noteEdit.getText().toString())) {
                                noteEdit.setError("Cannot be empty !");
                                noteEdit.requestFocus();
                            } else {
//DB INSERT NOTE
                                try {
                                    databaseHelper.insertNote(name, noteEdit.getText().toString().trim(),
                                            dateView.getText().toString().trim(),
                                            id);
                                    noteList();
                                    Toast.makeText(PlanItemActivity.this, "NOTE ADDED", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                dialog1.dismiss();
                                databaseHelper.close();
                            }
                        }
                    }
                });
            }
        });
        noteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final CharSequence[] items = {"Edit", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(PlanItemActivity.this);
                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            //Edit
                            Cursor c = databaseHelper.getNote("SELECT * FROM NOTE_TABLE");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()) {
                                arrID.add(c.getInt(0));
                            }
                            showDialogUpdate(PlanItemActivity.this, arrID.get(position));
                            databaseHelper.close();
                        }
                        if (which == 1) {
                            //Delete
                            Cursor c = databaseHelper.getNote("SELECT * FROM NOTE_TABLE");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()) {
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                            databaseHelper.close();
                        }
                    }
                });
                dialog.show();

                return true;
            }
        });

//ADD TO CALENDAR
        addCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id2 = 0;
                desc();
                Cursor cursor = databaseHelper.checkIfAlreadyInsert("SELECT * FROM CALENDAR_TABLE WHERE VEGEID = "+id);
                while (cursor.moveToNext()){
                    id2 = cursor.getInt(3);
                }
                if (id2 == id){
                    Toast.makeText(PlanItemActivity.this, "Already added !", Toast.LENGTH_SHORT).show();
                    databaseHelper.close();
                }
                else {
                    try {
                        databaseHelper.insertCalendar(dateTxt.getText().toString().trim(), harvestTxt.getText().toString().trim(), id, description);
                        Toast.makeText(PlanItemActivity.this, "Harvest date added to Calendar", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    databaseHelper.close();
                }
            }
        });
    }



    private void showDialogDelete(int idNote) {
        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(PlanItemActivity.this);
        dialogDelete.setTitle("Warning !!");
        dialogDelete.setMessage("Are you sure to delete ?");
        dialogDelete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    databaseHelper.deleteNote(idNote, id);
                    Toast.makeText(PlanItemActivity.this, "DELETED", Toast.LENGTH_SHORT).show();
                    noteList();
                } catch (Exception e) {
                    Log.e("Delete error", e.getMessage());
                }
                databaseHelper.close();
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

    public void showDialogUpdate(Activity activity, int position) {
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.edit_dialog);
        dialog.setTitle("Edit");

        EditText edtNote = dialog.findViewById(R.id.noteEditText);
        Button saveButton = dialog.findViewById(R.id.saveButton);

        Cursor cursor = databaseHelper.getNote("SELECT * FROM NOTE_TABLE WHERE ID=" + position + " AND VEGEID=" + id);
        while (cursor.moveToNext()) {
            String note = cursor.getString(3);
            edtNote.setText(note);
        }
        mAdapter.notifyDataSetChanged();

        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.3);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtNote.getText().toString().trim())) {
                    edtNote.setError("Cannot be empty");
                    edtNote.requestFocus();
                } else {
                    try {
                        databaseHelper.updateNote(edtNote.getText().toString().trim(),
                                position, id);
                        Toast.makeText(PlanItemActivity.this, "SAVED", Toast.LENGTH_SHORT).show();
                        noteList();
                        dialog.dismiss();
                    } catch (Exception error) {
                        Log.e("Edit error", error.getMessage());
                    }
                    databaseHelper.close();
                }
            }
        });
    }


    public void noteList() {
        Cursor cursor = databaseHelper.getNote("SELECT * FROM NOTE_TABLE WHERE VEGEID=" + id);
        mList.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String vegetableName = cursor.getString(1);
            String dateOfNote = cursor.getString(2);
            String note = cursor.getString(3);
            int vegID = cursor.getInt(4);

            mList.add(new NoteModel(id, vegetableName, dateOfNote, note, vegID));
        }
        mAdapter.notifyDataSetChanged();
        databaseHelper.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void currentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        dateToday = simpleDateFormat.format(calendar.getTime());
    }

    private void forImage() {
        if (name.equals("EGGPLANT")) {
            imagePlan.setImageResource(R.drawable.eggplanttry);
        } else if (name.equals("TOMATO")) {
            imagePlan.setImageResource(R.drawable.tomatotry);
        } else if (name.equals("OKRA")) {
            imagePlan.setImageResource(R.drawable.okratry);
        } else if (name.equals("STRING BEANS")) {
            imagePlan.setImageResource(R.drawable.sitawtry);
        } else if (name.equals("SQUASH")) {
            imagePlan.setImageResource(R.drawable.squashtry);
        } else if (name.equals("PARSLEY")) {
            imagePlan.setImageResource(R.drawable.parsleytry);
        } else if (name.equals("WATER SPINACH")) {
            imagePlan.setImageResource(R.drawable.waterspinachtry);
        } else if (name.equals("LETTUCE")) {
            imagePlan.setImageResource(R.drawable.lettucetry);
        } else if (name.equals("BOTTLE GOURD")) {
            imagePlan.setImageResource(R.drawable.bottlegourdtry);
        } else if (name.equals("BITTER MELON")) {
            imagePlan.setImageResource(R.drawable.bittermelontry);
        }
    }

    public void desc(){
//EGGPLANT
        if (vegetableName.getText().equals("EGGPLANT")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//TOMATO
        if (vegetableName.getText().equals("TOMATO")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//OKRA
        if (vegetableName.getText().equals("OKRA")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//STRING BEANS
        if (vegetableName.getText().equals("STRING BEANS")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//SQUASH
        if (vegetableName.getText().equals("SQUASH")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//PARSLEY
        if (vegetableName.getText().equals("PARSLEY")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//WATER SPINACH
        if (vegetableName.getText().equals("WATER SPINACH")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//LETTUCE
        if (vegetableName.getText().equals("LETTUCE")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//BOTTLE GOURD
        if (vegetableName.getText().equals("BOTTLE GOURD")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
//BITTER MELON
        if (vegetableName.getText().equals("BITTER MELON")){
            description = "Estimated harvest date of "+vegetableName.getText().toString();
        }
    }
}