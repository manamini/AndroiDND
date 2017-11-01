package com.example.manam.dnd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.manam.dnd.R.id.add;
import static com.example.manam.dnd.R.id.weapATKBonus;

/**
 * Created by manam on 8/23/2017.
 */

public class Pop extends Activity {

    static EditText weapName;
    static EditText weapBon;
    static EditText weapDam;
    static EditText weapNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popper);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.75),(int)(height*.75));

        weapName = (EditText) findViewById(R.id.weapsName);
        weapBon = (EditText)findViewById(R.id.weapATKBonus);
        weapDam = (EditText) findViewById(R.id.weapDamage);
        weapNotes = (EditText) findViewById(R.id.weapNotes);
        Button add = (Button) findViewById(R.id.addWeaps);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("weapName",weapName.getText().toString());
                i.putExtra("weapATK",weapBon.getText().toString());
                i.putExtra("weapDam",weapDam.getText().toString());
                setResult(RESULT_OK,i);
                Toast.makeText(Pop.this, "Added: " + weapName.getText().toString(), Toast.LENGTH_SHORT).show();
                finish();
            }

    });

}
}
