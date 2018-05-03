package com.example.syl.person;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.syl.person.model.Client;
import com.example.syl.person.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        ArrayList<Object> persons = new ArrayList<>();
        persons.add(new Client("Peter Parker", 34, "Milk", true));
        persons.add(new Employee("James Smith", 30, "Seller", 856.54));
        persons.add(new Employee("Jack Sparrow", 27, "Shop assistant", 856.54));
        persons.add(new Client("Peter Parker", 34, "Meat", false));

        PersonAdapter personAdapter = new PersonAdapter(persons);
        recyclerView.setAdapter(personAdapter);
    }
}