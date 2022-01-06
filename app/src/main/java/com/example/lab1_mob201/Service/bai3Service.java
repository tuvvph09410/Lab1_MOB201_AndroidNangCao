package com.example.lab1_mob201.Service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class bai3Service extends IntentService {
    private int count = 0;

    public bai3Service() {
        super("bai3Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            String search = bundle.getString("search");
            char kytuSearch = bundle.getChar("kytu");
//            char[] charKyTuSearch = kytuSearch.toCharArray();
//            char kytu = charKyTuSearch[0];
            this.count = this.checkCharacter(kytuSearch, search);

        }
    }

    private int checkCharacter(char kytu, String search) {
        int count = 0;
        for (int i = 0; i < search.length(); i++) {
            if (search.charAt(i) == kytu) {
                count++;
            }

        }
        return count;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "count: " + count, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "kết thúc service", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

}
