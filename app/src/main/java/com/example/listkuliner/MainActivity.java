package com.example.listkuliner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recKuliner;
    private ArrayList<Kuliner> listKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recKuliner = findViewById(R.id.rec_kuliner);
        initData();

        recKuliner.setAdapter(new KulinerAdapter(listKuliner));
        recKuliner.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData(){
        this.listKuliner = new ArrayList<>();
        listKuliner.add(new Kuliner("Nasi Goreng Kampung", "15.000",
                "Nasi goreng kampung dengan resep warisan turun-temurun", R.drawable.nasgor));
        listKuliner.add(new Kuliner("Sandwich", "10.000",
                "Sandwich dengan isian yang banyak", R.drawable.rotibakar));
        listKuliner.add(new Kuliner("Siomay Bandung", "10.000",
                "Siomay dengan bumbu saus khas dari Bandung", R.drawable.siomay));

    }
}
