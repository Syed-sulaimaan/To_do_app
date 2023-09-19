package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
                implements AdapterView.OnItemClickListener {

    ListView Listview;
    ArrayAdapter arrayAdapter;
    ArrayList arrayList;
    EditText editText;



    String[] AnimeGirls = {"Rias Greamory","Akeno","Asiya" , "Rem", "Mikasa" , "Nezuko Chan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Listview = findViewById(R.id.AnimeItems);
        editText = findViewById(R.id.editTextMain);
        Button btnNext = findViewById(R.id.spnrbtn);

        arrayList = new ArrayList(Arrays.asList(AnimeGirls));

        //create the array adapter
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        btnNext.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           // Create an intent to start the SecondActivity
                                           Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                                           startActivity(intent);
                                       }
                                   });

        Listview.setAdapter(arrayAdapter);

        Listview.setOnItemClickListener(this);


        }
        public void addToArrayList(View view){

            String text = editText.getText().toString();

            if(editText.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter data", Toast.LENGTH_SHORT).show();
            }
            else {
                editText.getText().clear();

                arrayList.add(text);

                arrayAdapter.notifyDataSetChanged();
            }
    }

        @Override

        public void onItemClick(AdapterView<?>adapterView, View view, int pos, long l){
        String item = adapterView.getItemAtPosition(pos).toString();
        //remove data on click
            arrayList.remove(item);
        //notify
            arrayAdapter.notifyDataSetChanged();
        }
}