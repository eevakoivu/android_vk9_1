package com.example.vk9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner theaters = null;
    String[] theaterlist = {"Espoo Omena", "Espoo Sello", "Helsinki Itis", "Helsinki Kinopalatsi",
            "Helsinki Maxim", "Helsinki Tennispalatsi", "Vantaa Flamingo", "Jyväskylä Fantasia", "Kuopio Scala",
            "Lahti Kuvapalatsi", "Lappeenranta Strand", "Oulu Plaza", "Pori Promenadi", "Tampere Cine Atlas",
            "Tampere Plevna", "Turku Kinopalatsi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theaters = (Spinner) findViewById(R.id.theaters);

        theaters.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, theaterlist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        theaters.setAdapter(adapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}