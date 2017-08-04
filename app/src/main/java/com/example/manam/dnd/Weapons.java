package com.example.manam.dnd;

/**
 * Created by manam on 5/11/2017.
 */

import android.app.ListActivity;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Weapons extends Fragment{

    ListView l;
    ArrayList<String> weapNames = new ArrayList<String>();
    ArrayAdapter adapter;
    Button addWeap;
    ImageButton delWeap;
    EditText name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weapons, container, false);

        l = (ListView) rootView.findViewById(R.id.list);
        name = (EditText) rootView.findViewById(R.id.weapName);
        addWeap = (Button) rootView.findViewById(R.id.addWeapon);
        weapNames.add("");
        delWeap = (ImageButton) rootView.findViewById(R.id.delButton);

        adapter = new ArrayAdapter(getActivity(),R.layout.lstview,R.id.weapName,weapNames);
        l.setAdapter(adapter);

        addWeap.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                adapter.add("");
                adapter.notifyDataSetChanged();
            }
        });
//        delWeap.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v)
//            {
//                Toast.makeText(getActivity(), "OOOOOHHHH", Toast.LENGTH_SHORT).show();
//            }
//        });
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "OOOOOHHHH", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;

    }
}
