package com.example.manam.dnd;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.manam.dnd.stab.SlidingTabLayout;

import org.w3c.dom.Text;

public class MainActivity extends FragmentActivity {

    // variables for main activity
    public static String profic;
    String MyPreferences;
    public String Name = "Name";
    public String Level = "level";
    public String Exp = "Exp";
    public String Proficiency = "Proficiency";
    public String HP = "HP";
    public String HPM = "HPM";
    public String Armor = "Armor";
    public String Initiative = "Initiative";
    public String Speed = "Speed";
    public String Class = "Class";

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Layout manager that allows the user to flip through the pages
        Button save = (Button) findViewById(R.id.Save);
        Button load = (Button) findViewById(R.id.Load);
        Button clear = (Button) findViewById(R.id.Clear);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final EditText name = (EditText) findViewById(R.id.nametext);
        final EditText cclass = (EditText) findViewById(R.id.classtext);
        final EditText exp = (EditText) findViewById(R.id.exptext);
        final EditText hp = (EditText) findViewById(R.id.hptext);
        final EditText hpm = (EditText) findViewById(R.id.hpmax);
        final EditText armor = (EditText) findViewById(R.id.actext);
        final EditText init = (EditText) findViewById(R.id.inittext);
        final EditText speed = (EditText) findViewById(R.id.speedtext);
        final TextView level = (TextView) findViewById(R.id.leveltext);
        final TextView proficiency = (TextView) findViewById(R.id.proftext);
        MyPreferences = name.getText().toString();
        sPref = getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);

        if(sPref.contains(Name))
            name.setText(sPref.getString(Name,""));
        if(sPref.contains(Class))
            cclass.setText(sPref.getString(Class,""));
        if(sPref.contains(Exp))
            exp.setText(sPref.getString(Exp,""));
        if(sPref.contains(HP))
            hp.setText(sPref.getString(HP,""));
        if(sPref.contains(HPM))
            hpm.setText(sPref.getString(HPM,""));
        if(sPref.contains(Armor))
            armor.setText(sPref.getString(Armor,""));
        if(sPref.contains(Initiative))
            init.setText(sPref.getString(Initiative,""));
        if(sPref.contains(Speed))
            speed.setText(sPref.getString(Speed,""));
        if(sPref.contains(Level))
            level.setText(sPref.getString(Level,""));
        if(sPref.contains(Proficiency))
            proficiency.setText(sPref.getString(Proficiency,""));

        // getSupportFragmentManager allows use to interact with the fragments
        // MyFragmentPagerAdapter will return a fragment based on an index that is passed
        viewPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager(),
                MainActivity.this));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nam = name.getText().toString();
                String Cclas = cclass.getText().toString();
                String Ex = exp.getText().toString();
                String H = hp.getText().toString();
                String HPmax = hpm.getText().toString();
                String Armo = armor.getText().toString();
                String Ini = init.getText().toString();
                String Spee = speed.getText().toString();
                String Leve = level.getText().toString();
                String Proficien = proficiency.getText().toString();

                SharedPreferences.Editor editor = sPref.edit();

                editor.putString(Name,Nam);
                editor.putString(Class,Cclas);
                editor.putString(Exp,Ex);
                editor.putString(HP,H);
                editor.putString(HPM,HPmax);
                editor.putString(Armor,Armo);
                editor.putString(Initiative,Ini);
                editor.putString(Speed,Spee);
                editor.putString(Level,Leve);
                editor.putString(Proficiency,Proficien);
                editor.commit();
                Toast.makeText(MainActivity.this,"Saving: " + Nam,Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                cclass.setText("");
                exp.setText("");
                hp.setText("");
                hpm.setText("");
                armor.setText("");
                init.setText("");
                speed.setText("");
                level.setText("");
                proficiency.setText("");
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);
                if(sPref.contains(Name))
                    name.setText(sPref.getString(Name,""));
                if(sPref.contains(Class))
                    cclass.setText(sPref.getString(Class,""));
                if(sPref.contains(Exp))
                    exp.setText(sPref.getString(Exp,""));
                if(sPref.contains(HP))
                    hp.setText(sPref.getString(HP,""));
                if(sPref.contains(HPM))
                    hpm.setText(sPref.getString(HPM,""));
                if(sPref.contains(Armor))
                    armor.setText(sPref.getString(Armor,""));
                if(sPref.contains(Initiative))
                    init.setText(sPref.getString(Initiative,""));
                if(sPref.contains(Speed))
                    speed.setText(sPref.getString(Speed,""));
                if(sPref.contains(Level))
                    level.setText(sPref.getString(Level,""));
                if(sPref.contains(Proficiency))
                    proficiency.setText(sPref.getString(Proficiency,""));
            }
        });

    }
}
