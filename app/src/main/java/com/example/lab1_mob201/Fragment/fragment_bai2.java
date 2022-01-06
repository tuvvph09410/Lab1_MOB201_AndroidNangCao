package com.example.lab1_mob201.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_mob201.R;
import com.example.lab1_mob201.Service.bai2Service;


public class fragment_bai2 extends Fragment {
    private EditText edName, edYear;
    private Button btnStart, btnStop;
    private Intent intent;

    public fragment_bai2() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fragment_bai2 newInstance() {
        fragment_bai2 fragment = new fragment_bai2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bai2, container, false);
        this.initIntent();
        this.initViewById(view);
        this.clickButton();
        return view;
    }

    private void clickButton() {
        this.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String yearString = edYear.getText().toString();
                if (name.length() != 0 && yearString.length() != 0) {
                    try {
                        int year = Integer.parseInt(yearString);
                        edYear.setBackgroundColor(Color.WHITE);
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name);
                        bundle.putInt("year", year);
                        intent.putExtras(bundle);
                        requireActivity().startService(intent);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        edYear.setBackgroundColor(Color.RED);
                        Toast.makeText(getContext(), "Nhập sai định dạng năm", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                }

            }
        });
        this.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().stopService(intent);
            }
        });
    }

    private void initViewById(View view) {
        this.edName = view.findViewById(R.id.ed_name);
        this.edYear = view.findViewById(R.id.ed_year);
        this.btnStart = view.findViewById(R.id.btn_startService);
        this.btnStop = view.findViewById(R.id.btn_stopService);

    }

    private void initIntent() {
        intent = new Intent(getContext(), bai2Service.class);
    }
}