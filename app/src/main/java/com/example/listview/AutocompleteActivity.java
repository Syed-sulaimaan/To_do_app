package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutocompleteActivity extends AppCompatActivity {

    ArrayAdapter adapter;

    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);

        auto = findViewById(R.id.autoCompleteTextView);

        auto.setAdapter(adapter);
    }
}