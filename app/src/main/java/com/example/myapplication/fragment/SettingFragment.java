package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.myapplication.R;
import com.example.myapplication.utiles.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {


    private View view;
    private CheckBox checkbox_noImag;
    private CheckBox checkbox_nightImag;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        checkbox_noImag = (CheckBox) view.findViewById(R.id.checkbox_noImag);
        checkbox_nightImag = (CheckBox) view.findViewById(R.id.checkbox_nightImag);

        if (Constants.isNoImage) {
            checkbox_noImag.setChecked(true);
        } else {
            checkbox_noImag.setChecked(false);
        }

        checkbox_noImag.setOnClickListener(this);
       checkbox_nightImag.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.checkbox_noImag:
                if (Constants.isNoImage){
                    Constants.isNoImage=false;
                }else {
                    Constants.isNoImage=true;
                }
                break;
            case R.id.checkbox_nightImag:
                if (!Constants.isNightMode){
                    Constants.isNightMode=true;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    Constants.isNightMode=false;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                getActivity().recreate();
                break;
        }
    }
}
