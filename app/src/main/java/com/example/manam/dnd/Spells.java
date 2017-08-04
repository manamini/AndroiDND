package com.example.manam.dnd;

/**
 * Created by manam on 5/11/2017.
 */

import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Spells extends Fragment{

    static TextView spellDC, spellAttack;

    static int spinPosition;
    static Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spellstab, container, false);

        spinner = (Spinner) rootView.findViewById(R.id.ATTR);

        spellDC = (TextView) rootView.findViewById(R.id.DC);
        spellAttack = (TextView) rootView.findViewById(R.id.SAB);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.spell_mod, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String dc = "8";
                //spinPosition =position;
                switch(position){
                    case 0:
                        break;
                    case 1:
                        spellDC.setText(""+(Integer.parseInt(dc) + Integer.parseInt(Stats.intelligenceBonus.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                        spellAttack.setText("+" +(Integer.parseInt(Stats.intelligenceBonus.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                        break;
                    case 2:
                        spellDC.setText(""+(Integer.parseInt(dc) + Integer.parseInt(Stats.wisdomBonus.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                        spellAttack.setText("+" +(Integer.parseInt(Stats.wisdomBonus.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                        break;
                    case 3:
                        spellDC.setText(""+(Integer.parseInt(dc) + Integer.parseInt(Stats.charismaBonus.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                        spellAttack.setText("+" +(Integer.parseInt(Stats.charismaBonus.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return rootView;
    }


}
