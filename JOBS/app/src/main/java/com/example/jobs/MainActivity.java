package com.example.jobs;

import android.graphics.Movie;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jobs.Adapter.CustomAdapter;
import com.example.jobs.Interface.GetDataService;
import com.example.jobs.Model.jobs;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText txtBuscar;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBuscar = findViewById(R.id.txtBuscar);
        floatingActionButton = findViewById(R.id.bfloBuscar);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String apikey = "6fc43ba7";
                String name = txtBuscar.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://jobs.github.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GetDataService movieInterface = retrofit.create(GetDataService.class);
                Call<List<jobs>> methodSearch = movieInterface.searchMovie(name);

                methodSearch.enqueue(new Callback<List<jobs>>() {

                    @Override
                    public void onResponse(Call<List<jobs>> call, Response<List<jobs>> response) {
                        if (response.isSuccessful()) {

                            generarLista(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<jobs>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Fallo la conexión",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void generarLista(List<jobs> jobs) {
        recyclerView = findViewById(R.id.reciclerView);
        adapter = new CustomAdapter(jobs,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Toast.makeText(MainActivity.this, adapter.getItemCount() + " registros encontrados",Toast.LENGTH_LONG).show();
    }
}
