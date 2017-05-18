package com.example.manam.dnd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by manam on 5/15/2017.
 */

public class Top_Fragment  extends Fragment {

    //User name and experience edits
    private EditText usersNameEditText, usersExperienceEditText;
    // Level Textview
    private TextView level;
    public TextView proficiency;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.top_fragment, container, false);


        // User texts
        usersNameEditText = (EditText) rootView.findViewById(R.id.nametext);
        usersExperienceEditText = (EditText) rootView.findViewById(R.id.exptext);
        level = (TextView) rootView.findViewById(R.id.leveltext);
        proficiency = (TextView) rootView.findViewById(R.id.proftext);

        usersExperienceEditText.addTextChangedListener(expEditWatcher);

        return rootView;
    }

    private final TextWatcher expEditWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(usersExperienceEditText.getText().toString().length()>0) {
                if (Integer.parseInt(usersExperienceEditText.getText().toString())<300) {
                    level.setText("1");
                    proficiency.setText("2");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=300 && Integer.parseInt(usersExperienceEditText.getText().toString())<900) {
                    level.setText("2");
                    proficiency.setText("2");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=900 && Integer.parseInt(usersExperienceEditText.getText().toString())<2700) {
                    level.setText("3");
                    proficiency.setText("2");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=2700 && Integer.parseInt(usersExperienceEditText.getText().toString())<6500) {
                    level.setText("4");
                    proficiency.setText("2");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=6500 && Integer.parseInt(usersExperienceEditText.getText().toString())<14000) {
                    level.setText("5");
                    proficiency.setText("3");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=14000 && Integer.parseInt(usersExperienceEditText.getText().toString())<23000) {
                    level.setText("6");
                    proficiency.setText("3");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=23000 && Integer.parseInt(usersExperienceEditText.getText().toString())<34000) {
                    level.setText("7");
                    proficiency.setText("3");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=34000 && Integer.parseInt(usersExperienceEditText.getText().toString())<48000) {
                    level.setText("8");
                    proficiency.setText("3");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=48000 && Integer.parseInt(usersExperienceEditText.getText().toString())<64000) {
                    level.setText("9");
                    proficiency.setText("4");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=64000 && Integer.parseInt(usersExperienceEditText.getText().toString())<85000) {
                    level.setText("10");
                    proficiency.setText("4");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=85000 && Integer.parseInt(usersExperienceEditText.getText().toString())<100000) {
                    level.setText("11");
                    proficiency.setText("4");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=100000 && Integer.parseInt(usersExperienceEditText.getText().toString())<120000) {
                    level.setText("12");
                    proficiency.setText("4");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=120000 && Integer.parseInt(usersExperienceEditText.getText().toString())<140000) {
                    level.setText("13");
                    proficiency.setText("5");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=140000 && Integer.parseInt(usersExperienceEditText.getText().toString())<165000) {
                    level.setText("14");
                    proficiency.setText("5");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=165000 && Integer.parseInt(usersExperienceEditText.getText().toString())<195000) {
                    level.setText("15");
                    proficiency.setText("5");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=195000 && Integer.parseInt(usersExperienceEditText.getText().toString())<225000) {
                    level.setText("16");
                    proficiency.setText("5");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=225000 && Integer.parseInt(usersExperienceEditText.getText().toString())<265000) {
                    level.setText("17");
                    proficiency.setText("6");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=265000 && Integer.parseInt(usersExperienceEditText.getText().toString())<305000) {
                    level.setText("18");
                    proficiency.setText("6");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=305000 && Integer.parseInt(usersExperienceEditText.getText().toString())<355000) {
                    level.setText("19");
                    proficiency.setText("6");
                    MainActivity.profic = (""+proficiency.getText().toString());
                }else if(Integer.parseInt(usersExperienceEditText.getText().toString())>=355000) {
                    level.setText("20");
                    proficiency.setText("6");
                    MainActivity.profic = (""+proficiency.getText().toString());

                }


            }
        }
    };
}