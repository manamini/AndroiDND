package com.example.manam.dnd;

/**
 * Created by manam on 5/11/2017.
 */

import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class Weapons extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weapons, container, false);
        return rootView;
    }
}
