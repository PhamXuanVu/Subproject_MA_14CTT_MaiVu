package com.example.detai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class Screen2 extends AppCompatActivity {
    private ImageView img1;
    private GoogleSignInClient mGoogleSignInClient;
    private ImageView bt_logout;

    private TextView textView;
    private RecyclerView recyclerView,recyclerView2;
    private RecyclerView.LayoutManager layoutManager;
    private SanPhamAdapter2 adapter;
    private ArrayList<SanPham> sanPhams = new ArrayList<>();

    private ArrayList<SanPham> sanPham2s = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        bt_logout = findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bt_logout:
                        signOut();

                        break;
                }
            }
        });

        recyclerView = findViewById(R.id.recyclerView1);
        sanPhams.add(new SanPham(R.drawable.img_1));
        sanPhams.add(new SanPham(R.drawable.img_1));
        sanPhams.add(new SanPham(R.drawable.img_1));
        sanPhams.add(new SanPham(R.drawable.img_1));
        sanPhams.add(new SanPham(R.drawable.img_1));
        layoutManager = new GridLayoutManager(Screen2.this, 1, GridLayoutManager.HORIZONTAL, false);
        adapter = new SanPhamAdapter2(sanPhams, Screen2.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView2 = findViewById(R.id.recyclerView2);
        sanPham2s.add(new SanPham(R.drawable.img_2));
        sanPham2s.add(new SanPham(R.drawable.img_2));
        sanPham2s.add(new SanPham(R.drawable.img_2));
        sanPham2s.add(new SanPham(R.drawable.img_2));
        sanPham2s.add(new SanPham(R.drawable.img_2));
        layoutManager = new GridLayoutManager(Screen2.this, 1, GridLayoutManager.HORIZONTAL, false);
        adapter = new SanPhamAdapter2(sanPham2s, Screen2.this);
        recyclerView2.setAdapter(adapter);
        recyclerView2.setLayoutManager(layoutManager);
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Screen2.this,"Logout succesful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Screen2.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}