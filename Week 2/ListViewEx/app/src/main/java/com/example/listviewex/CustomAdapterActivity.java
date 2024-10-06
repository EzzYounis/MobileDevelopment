package com.example.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterActivity extends AppCompatActivity {
    final List<Animal> animals = new ArrayList<Animal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        animals.add(new Animal("Cat",R.mipmap.cat));
        animals.add(new Animal("Dog",R.mipmap.dog));
        animals.add(new Animal("Goat",R.mipmap.goat));
        animals.add(new Animal("Elephant",R.mipmap.elephant));
        animals.add(new Animal("Lion",R.mipmap.lion));
        animals.add(new Animal("Monkey",R.mipmap.monkey));
        final ListView listView = (ListView) findViewById(R.id.listview);
        AnimalAdapter adapter = new AnimalAdapter(this,animals );
        listView.setAdapter(adapter);


    }
}