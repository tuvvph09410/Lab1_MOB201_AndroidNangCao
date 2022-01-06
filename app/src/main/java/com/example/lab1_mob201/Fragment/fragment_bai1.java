package com.example.lab1_mob201.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lab1_mob201.R;
import com.example.lab1_mob201.Service.bai1Service;


public class fragment_bai1 extends Fragment {
    private Button btn_initService, btn_stopService;
    private Intent intent;

    public fragment_bai1() {
        // Required empty public constructor
    }


    public static fragment_bai1 newInstance() {
        fragment_bai1 fragment = new fragment_bai1();
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
        View view = inflater.inflate(R.layout.fragment_bai1, container, false);

        intent = new Intent(getContext(), bai1Service.class);

        this.initViewById(view);

        this.clickButton();

        return view;
    }

    private void clickButton() {
        this.btn_initService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", "Vũ Văn Tú");
                bundle.putString("mssv", "PH09410");
                bundle.putInt("year", 1999);
                intent.putExtras(bundle);
                requireActivity().startService(intent);

            }
        });
        this.btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().stopService(intent);
            }
        });
    }

    private void initViewById(View view) {
        this.btn_initService = view.findViewById(R.id.btn_initService);
        this.btn_stopService = view.findViewById(R.id.btn_stopService);
    }
}