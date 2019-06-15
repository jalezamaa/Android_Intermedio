package com.example.peoplecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<Person> items;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        public CardView personcardview;
        public ImageView imagen;
        public TextView nombre;
        public TextView dni;
        public TextView edad;

        public PersonViewHolder(View v)
        {
            super(v);
            personcardview = (CardView) v.findViewById(R.id.person_card);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            dni = (TextView) v.findViewById(R.id.dni);
            edad = (TextView) v.findViewById(R.id.edad);
        }
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_card,viewGroup,false);

        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder viewHolder, final int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.dni.setText("DNI:" + items.get(i).getDni());
        viewHolder.edad.setText("Edad:" + String.valueOf(items.get(i).getEdad()));


        viewHolder.personcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("curImagen", items.get(i).getImagen());
                bundle.putString("curNombre", items.get(i).getNombre());
                bundle.putString("curDni", items.get(i).getDni());
                bundle.putString("curBio", items.get(i).getBio());
                Intent iconIntent = new Intent(view.getContext(), BioActivity.class);
                iconIntent.putExtras(bundle);
                view.getContext().startActivity(iconIntent);
            }
        }) ;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Person> getItems()
    {
        return this.items;
    }

    public PersonAdapter(List<Person> items) {this .items = items;}
}
