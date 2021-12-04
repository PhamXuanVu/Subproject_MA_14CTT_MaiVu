package com.example.detai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;

public class Screen3 extends AppCompatActivity {
    private MyService myService;
    private boolean isBound = false;
    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        final ImageView img_play = findViewById(R.id.bt_play);
        final ImageView img_pause = findViewById(R.id.bt_pause);
        connection = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {

                isBound = false;
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyService.MyBinder binder = (MyService.MyBinder) service;
                myService = binder.getService();
                isBound = true;
            }
        };


        final Intent intent =
                new Intent(Screen3.this,
                        MyService.class);

        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bindService(intent, connection, Context.BIND_AUTO_CREATE);

            }
        });

        img_pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (isBound) {
                    unbindService(connection);
                    isBound = false;
                }
            }
        });
        final ImageView img_back1 = findViewById(R.id.img_back1);
        img_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Screen3.this,Screen2.class);
                startActivity(intent1);
            }
        });
        final ImageView img_screen4 = findViewById(R.id.img_screen4);
        img_screen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Screen3.this,Screen4.class);
                startActivity(intent2);
            }
        });
    }

}