package com.example.vk9_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner theaters = null;
    Button timebutton = null;
    CalendarView calendarView = null;
    EditText editText = null;
    ListView listView = null;
    int hour, minute;
    int year, month, day;
    String[] theaterlist = {"Espoo Omena", "Espoo Sello", "Helsinki Itis", "Helsinki Kinopalatsi",
            "Helsinki Maxim", "Helsinki Tennispalatsi", "Vantaa Flamingo", "Jyväskylä Fantasia", "Kuopio Scala",
            "Lahti Kuvapalatsi", "Lappeenranta Strand", "Oulu Plaza", "Pori Promenadi", "Tampere Cine Atlas",
            "Tampere Plevna", "Turku Kinopalatsi"};
    String[] movies = {"movie1", "movie2", "movie3"};

    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theaters = (Spinner) findViewById(R.id.theaters);
        timebutton = (Button) findViewById(R.id.timebutton);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);

        spinner();
        calendarView();
        editText();


    }

    public void spinner(){
        theaters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, theaterlist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        theaters.setAdapter(adapter);


    }

    public void calendarView(){
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                year=i;
                month=i1+1;
                day=i2;
                //System.out.println(day+"."+month+"."+year);
            }
        });
    }

    public void timePicker(View v){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                hour = i;
                minute = i1;
                timebutton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour,minute));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    //edittext
    //nimi.setontextchangelastener(new NiMi.OntextchangeListener)
    public void listView(){
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movies);
        listView.setAdapter(adapter);
    }


    public void editText(){
        editText.setOn
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }


}