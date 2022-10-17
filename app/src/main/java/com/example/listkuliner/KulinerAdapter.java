package com.example.listkuliner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.ViewHolder> {

    public KulinerAdapter(ArrayList<Kuliner> listKuliner){
        this.listKuliner = listKuliner;
    }

    private ArrayList<Kuliner> listKuliner;

    @NonNull
    @Override
    public KulinerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_kuliner, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KulinerAdapter.ViewHolder holder, int position) {
        Kuliner kuliner = listKuliner.get(position);
        holder.txtNama.setText(kuliner.getNama());
        holder.txtAlamat.setText(kuliner.getAlamat());
        holder.txtDeskripsi.setText(kuliner.getDeskripsi());
        holder.imgFoto.setImageResource(kuliner.getId_gambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),item_Desc.class);

                intent.putExtra("foto", kuliner.getId_gambar());
                intent.putExtra("nama", kuliner.getNama());
                intent.putExtra("Deskripsi", kuliner.getDeskripsi());
                intent.putExtra("Harga", kuliner.getAlamat());

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKuliner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama, txtAlamat, txtDeskripsi;
        public ImageView imgFoto;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) (itemView.findViewById(R.id.txtNama));
            txtAlamat = (TextView) itemView.findViewById(R.id.txtAlamat);
            imgFoto = (ImageView) (itemView.findViewById(R.id.imgFoto));
            txtDeskripsi = (TextView) (itemView.findViewById(R.id.txtDeskripsi));
            this.itemView = (ConstraintLayout) itemView.findViewById(R.id.mainLayout);
        }
    }
}
