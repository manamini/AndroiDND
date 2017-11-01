package com.example.manam.dnd;

/**
 * Created by manam on 5/11/2017.
 */

import android.app.ListActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.List;

public class Weapons extends Fragment{
    RecyclerView weapNames;
    RecyclerView.Adapter weapAdapter;
    RecyclerView.LayoutManager weapLayoutManager;

    static Button addWeap;
    ImageButton delWeap;
    EditText name;
    static List<WeapInfo> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weapons, container, false);
        weapNames = (RecyclerView) rootView.findViewById(R.id.list);

        weapNames.setHasFixedSize(true);

        weapLayoutManager = new LinearLayoutManager(getActivity());
        weapNames.setLayoutManager(weapLayoutManager);

        name = (EditText) rootView.findViewById(R.id.weapName);
        addWeap = (Button) rootView.findViewById(R.id.addWeapon);
        delWeap = (ImageButton) rootView.findViewById(R.id.delButton);

        weapAdapter = new weapAdaptor(getActivity(),getData());
        weapNames.setAdapter(weapAdapter);

        return rootView;
    }

    public static List<WeapInfo> getData(){

        final int del = R.drawable.del;
        final int inf = R.drawable.weapinfo;

                final WeapInfo current = new WeapInfo();
                current.name ="";
                current.atkBonus = "";
                current.damage = "";
                current.iconId = del;
                current.infoId = inf;
                data.add(current);

        return data;
    }
}
