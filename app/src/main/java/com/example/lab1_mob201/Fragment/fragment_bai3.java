package com.example.lab1_mob201.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1_mob201.R;
import com.example.lab1_mob201.Service.bai3Service;


public class fragment_bai3 extends Fragment {
    private EditText edSearch, edChar;
    private Button btnSearch;
    private Intent intent;

    public fragment_bai3() {
        // Required empty public constructor
    }

    public static fragment_bai3 newInstance() {
        fragment_bai3 fragment = new fragment_bai3();

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
        View view = inflater.inflate(R.layout.fragment_bai3, container, false);
        this.initViewById(view);
        this.initIntent();
        this.clickButton();
        return view;
    }

    private void initIntent() {
        this.intent = new Intent(getContext(), bai3Service.class);
    }

    private void clickButton() {
        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = edSearch.getText().toString();
                String kyTuSearch = edChar.getText().toString();
                if (search.length() != 0 && kyTuSearch.length() != 0) {
                    char[] kyTu=kyTuSearch.toCharArray();
                    Bundle bundle = new Bundle();
                    bundle.putString("search", search);
                    bundle.putChar("kytu", kyTu[0]);
                    intent.putExtras(bundle);
                    requireActivity().startService(intent);
                } else {
                    Toast.makeText(getContext(), "Vui lòng nhập đầy đủ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initViewById(View view) {
        this.edSearch = view.findViewById(R.id.ed_search);
        this.btnSearch = view.findViewById(R.id.btn_search);
        this.edChar = view.findViewById(R.id.ed_char);
    }
}