package com.example.manam.dnd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by manam on 5/13/2017.
 */

public class Abilities  extends Fragment {

    static TextView abilities;
    static EditText ablist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.abilitiestab, container, false);

        abilities = (TextView) rootView.findViewById(R.id.abilities);
        ablist = (EditText) rootView.findViewById(R.id.ablist);

        return rootView;
    }
}