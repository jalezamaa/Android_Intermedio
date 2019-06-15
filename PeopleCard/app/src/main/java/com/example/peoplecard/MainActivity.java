package com.example.peoplecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FillPersona();

        //Obtener Recycler
        recyclerView = (RecyclerView) findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(true);

        //Usar un Administrador para LinearLayout
        lmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lmanager);

        adapter = new PersonAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private void FillPersona()
    {
        items.add(new Person(R.drawable.face01,"Marlon Leandro","44525895",35,"MBA Ingeniero de Sistemas"));
        items.add(new Person(R.drawable.face02,"Juan Perez","54125478",35,"MBA Ingeniero de Sistemas"));
        items.add(new Person(R.drawable.face03,"Pedro Miranda","56895645",35,"MBA Ingeniero de Sistemas"));
        items.add(new Person(R.drawable.face04,"Mateo Montero","56542541",35,"MBA Ingeniero de Sistemas"));
        items.add(new Person(R.drawable.face05,"Hugo Santana","45844527",35,"MBA Ingeniero de Sistemas"));
        items.add(new Person(R.drawable.face06,"Pedro Jose","97642846",35,"MBA Ingeniero de Sistemas"));
        items.add(new Person(R.drawable.face07,"Carlos Gonzales","73918246",35,"MBA Ingeniero de Sistemas"));
        items.add(new Person(R.drawable.face08,"Alex Lezama","44656159",35,"MBA Ingeniero de Sistemas"));
    }
}
