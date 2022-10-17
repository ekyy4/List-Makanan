package com.example.listkuliner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class item_Desc extends AppCompatActivity {

    ImageView fotoMakanan;
    TextView nama,desc,hrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_desc);

        fotoMakanan = findViewById(R.id.fotoMakanan);
        nama = findViewById(R.id.nama);
        desc = findViewById(R.id.desc);
        hrg = findViewById(R.id.hrg);

        getIncomingExtra();

    }

    private void getIncomingExtra(){

        if(getIntent().hasExtra("foto") && getIntent().hasExtra("nama") && getIntent().hasExtra("Deskripsi") && getIntent().hasExtra("Harga")){

            int imgFoto = getIntent().getIntExtra("foto", 1);
            String txtNama = getIntent().getStringExtra("nama");
            String txtDeskripsi = getIntent().getStringExtra("Deskripsi");
            String txtAlamat = getIntent().getStringExtra("Harga");

            setdataActivity(imgFoto,txtNama ,txtDeskripsi, txtAlamat );
        }

    }

    private void setdataActivity(int imgFoto, String txtNama, String txtDeskripsi, String txtAlamat){
        fotoMakanan.setImageResource(imgFoto);
        nama.setText(txtNama);
        desc.setText(txtDeskripsi);
        hrg.setText(txtAlamat);

    }
}