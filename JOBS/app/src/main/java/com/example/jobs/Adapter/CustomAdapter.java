package com.example.jobs.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jobs.Model.jobs;
import com.example.jobs.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<jobs> dataList;
    private Context context;

    public CustomAdapter(List<jobs> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int posicion) {

        holder.txtTitulo.setText(dataList.get(posicion).getTitle());
        holder.txtCompañia.setText(dataList.get(posicion).getCompany());
        holder.txtDescripcion.setText(dataList.get(posicion).getDescription());

        Glide.with(context)
                .load(dataList.get(posicion).getCompany_logo())
                .into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitulo;
        TextView txtCompañia;
        TextView txtDescripcion;

        private ImageView logo;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            txtTitulo = mView.findViewById(R.id.title);
            txtCompañia = mView.findViewById(R.id.company);
            txtDescripcion = mView.findViewById(R.id.description);
            logo = mView.findViewById(R.id.logo);
        }
    }
}
