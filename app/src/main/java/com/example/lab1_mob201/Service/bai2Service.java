package com.example.lab1_mob201.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class bai2Service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "khởi tạo service", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            String name = bundle.getString("name");
            int year = bundle.getInt("year");
            String toast = "Service intent: " + "Tên: " + name + " , Tuổi: " + year;
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "kết thúc service", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
