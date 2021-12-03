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

//        img_pause.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                if (isBound) {
//                    unbindService(connection);
//                    isBound = false;
//                }
//            }
//        });
    }
}