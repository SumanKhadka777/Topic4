package com.suman.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countries[] = {

            "Nepal","Kathmandu",
            "India","New Delhi",
            "China","Beijing",
            "UK","London",
            "US","Washington DC",
            "Canada","Ottawa"




    };
    ListView lstCountries;

    private Map<String,String> countryMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lstCountries = findViewById(R.id.lstCountries);

        countryMap= new HashMap<>();
        for (int i=0;i<countries.length; i+=2){

        countryMap.put(countries[i], countries[i+1]);


        }

        ArrayAdapter countryAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new ArrayList<String>(countryMap.keySet()));
        lstCountries.setAdapter(countryAdapter);

        lstCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = countryMap.get(country);
                Toast.makeText(MainActivity.this, "Capital of "+ country+"is:" + capital, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
