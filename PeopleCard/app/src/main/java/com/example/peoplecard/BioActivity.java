package com.example.peoplecard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BioActivity extends AppCompatActivity {
    TextView nombre;
    TextView dni;
    TextView bio;
    ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (TextView) findViewById(R.id.nombre);
        dni= (TextView) findViewById(R.id.dni);
        bio = (TextView) findViewById(R.id.biografia);
        imagem = (ImageView) findViewById(R.id.imagen);

        nombre.setText(getIntent().getExtras().getString("curNombre"));
        dni.setText("DNI:" + getIntent().getExtras().getString("curDni"));
        bio.setText(getIntent().getExtras().getString("curBio"));
        imagem.setImageResource(getIntent().getExtras().getInt("curImagen"));
    }

}
