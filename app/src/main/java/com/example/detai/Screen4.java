package com.example.detai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Screen4 extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SanPhamAdapter4 adapter;
    private ArrayList<SanPham> sanPhams = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        recyclerView = findViewById(R.id.recyclerView1);
        sanPhams.add(new SanPham(R.drawable.img_23));
        sanPhams.add(new SanPham(R.drawable.img_23));
        sanPhams.add(new SanPham(R.drawable.img_23));
        sanPhams.add(new SanPham(R.drawable.img_23));
        sanPhams.add(new SanPham(R.drawable.img_23));
        sanPhams.add(new SanPham(R.drawable.img_23));
        sanPhams.add(new SanPham(R.drawable.img_23));
        sanPhams.add(new SanPham(R.drawable.img_23));
        layoutManager = new GridLayoutManager(Screen4.this, 1, GridLayoutManager.VERTICAL, false);
        adapter = new SanPhamAdapter4(sanPhams, Screen4.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        final ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Screen4.this,Screen3.class);
                startActivity(intent1);
            }
        });

    }
}