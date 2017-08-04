package com.example.manam.dnd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by manam on 5/13/2017.
 */

public class Notes  extends Fragment {

    static EditText notes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notes, container, false);

        notes = (EditText) rootView.findViewById(R.id.notes);

        return rootView;
    }
}