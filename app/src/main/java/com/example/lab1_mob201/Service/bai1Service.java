package com.example.lab1_mob201.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class bai1Service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // hàm khởi tạo
    @Override
    public void onCreate() {
        Toast.makeText(this, "new service was started", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    //hàm nhận và sử lý dự liệu
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //lấy giá trị bundle từ Intent

        Bundle student = intent.getExtras();
        String name = student.getString("name");
        String mssv = student.getString("mssv");
        int year = student.getInt("year");
        String toast = "lấy intent bằng service: " + " Tên: " + name + ", Mã Sinh Viên: " + mssv + ", Tuổi: " + year;
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    //hàm huỷ
    @Override
    public void onDestroy() {
        Toast.makeText(this, " service was stopped", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
