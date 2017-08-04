package com.example.manam.dnd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.OutputStreamWriter;

/**
 * Created by manam on 5/16/2017.
 */

public class Main extends Fragment {

    public Button save, load;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main, container, false);

        save = (Button) rootView.findViewById(R.id.Save);
        load = (Button) rootView.findViewById(R.id.Load);
        return rootView;
    }

    public void onSavedClick(View v){


    }

}
