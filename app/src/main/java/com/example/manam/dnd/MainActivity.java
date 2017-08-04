package com.example.manam.dnd;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import static com.example.manam.dnd.R.id.parent;

public class MainActivity extends FragmentActivity {

    // variables for main activity
    public static String profic;


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

    public String Str = "Str";
    public String Dex = "Dex";
    public String Con = "Con";
    public String Int = "Int";
    public String Wis = "Wis";
    public String Chr = "Chr";

    public String strsave = "strSave";
    public String dexsave = "dexSave";
    public String consave = "conSave";
    public String intsave = "intSave";
    public String wissave = "wisSave";
    public String chrsave = "chrSave";

    public String athletics = "athletics";

    public String acrobatics = "acrobatics";
    public String sleight = "sleight";
    public String stealth = "stealth";

    public String arcana = "arcana";
    public String history = "history";
    public String investigation = "investigation";
    public String nature = "nature";
    public String religion = "religion";

    public String animal = "animal";
    public String insight = "insight";
    public String medicine = "medicine";
    public String perception = "perception";
    public String survival = "survival";

    public String deception = "deception";
    public String intimidation = "intimidation";
    public String performance = "performance";
    public String persuasion = "persuasion";

    public String spinLoc = "spinloc";
    public String dc = "dc";
    public String spellAtt = "spellAtt";

    public String Note = "notes";

    public Spinner load;
    List<String> namesList = new ArrayList<>();
    Gson gson = new Gson();
    public String jsonText;
    public String JtoGText;
    public String defName = "Default";

    public int spin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Layout manager that allows the user to flip through the pages
        final Button save = (Button) findViewById(R.id.Save);
        load = (Spinner) findViewById(R.id.Load);
        final Button clear = (Button) findViewById(R.id.Clear);
        Button delete = (Button) findViewById(R.id.Delete);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        final ArrayAdapter<String> loadAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,namesList);
        loadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        load.setAdapter(loadAdapter);
        loadAdapter.add(defName);

        gson = new GsonBuilder().create();

        jsonText = PreferenceData.loadData(getBaseContext(),defName,JtoGText,"");
        List<String> text = gson.fromJson(jsonText, List.class);
        if(text!=null) {
            namesList.addAll(text);
            namesList.remove(1);
        }

        //Toast.makeText(getBaseContext(), "This: " + jsonText,Toast.LENGTH_SHORT).show();


        viewPager.setOffscreenPageLimit(5);

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

        jsonText = PreferenceData.loadData(getBaseContext(),name.getText().toString(),JtoGText,"");
        viewPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager(),
                MainActivity.this));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!namesList.contains(name.getText().toString())) {
                    loadAdapter.add(name.getText().toString());
                }
                //PreferenceData.sharedprefs = getSharedPreferences(name.getText().toString(),getBaseContext().MODE_APPEND);
                PreferenceData.saveData(getBaseContext(),name.getText().toString(), Name, name.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),Class, cclass.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),Exp, exp.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),HP, hp.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),HPM, hpm.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),Armor, armor.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),Initiative, init.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),Speed, speed.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),Level, level.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(),Proficiency, proficiency.getText().toString());

                PreferenceData.saveData(getBaseContext(), name.getText().toString(), Str, Stats.strengthEdit.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(), Dex, Stats.dexterityEdit.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(), Con, Stats.constitutionEdit.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(), Int, Stats.intelligenceEdit.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(), Wis, Stats.wisdomEdit.getText().toString());
                PreferenceData.saveData(getBaseContext(), name.getText().toString(), Chr, Stats.charismaEdit.getText().toString());

                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), strsave, Stats.strSave.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), athletics, Stats.athletics.isChecked());

                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), dexsave, Stats.dexSave.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), acrobatics, Stats.acrobatics.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), sleight, Stats.sleight.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), stealth, Stats.stealth.isChecked());

                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), consave, Stats.conSave.isChecked());

                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), intsave, Stats.intSave.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), arcana, Stats.arcana.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), history, Stats.history.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), investigation, Stats.investigation.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), nature, Stats.nature.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), religion, Stats.religion.isChecked());

                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), wissave, Stats.wisSave.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), animal, Stats.animal.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), insight, Stats.insight.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), medicine, Stats.medicine.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), perception, Stats.perception.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), survival, Stats.survival.isChecked());

                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), chrsave, Stats.chrSave.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), deception, Stats.deception.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), intimidation, Stats.intimidation.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), performance, Stats.performance.isChecked());
                PreferenceData.saveChecks(getBaseContext(), name.getText().toString(), persuasion, Stats.persuasion.isChecked());

                PreferenceData.saveSpinner(getBaseContext(),name.getText().toString(),spinLoc,Spells.spinPosition);

                PreferenceData.saveData(getBaseContext(),name.getText().toString(), Note, Notes.notes.getText().toString());

                jsonText = gson.toJson(namesList);
                PreferenceData.saveData(getBaseContext(),defName,JtoGText,jsonText);

                Toast.makeText(getBaseContext(), "Saved: " + name.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    name.setText("");
                    level.setText("");
                    exp.setText("");
                    proficiency.setText("");
                    hp.setText("");
                    hpm.setText("");
                    armor.setText("");
                    init.setText("");
                    speed.setText("");
                    cclass.setText("");

                    Stats.strengthEdit.setText(""); ;
                    Stats.dexterityEdit.setText("");
                    Stats.constitutionEdit.setText("");
                    Stats.intelligenceEdit.setText("");
                    Stats.wisdomEdit.setText("");
                    Stats.charismaEdit.setText("");

                    //Saves proficiency
                    Stats.strSave.setChecked(false);
                    Stats.dexSave.setChecked(false);
                    Stats.conSave.setChecked(false);
                    Stats.intSave.setChecked(false);
                    Stats.wisSave.setChecked(false);
                    Stats.chrSave.setChecked(false);
                    //Skill proficiency based on attribute
                    Stats.athletics.setChecked(false);
                    Stats.acrobatics.setChecked(false);
                    Stats.sleight.setChecked(false);
                    Stats.stealth.setChecked(false);
                    Stats.arcana.setChecked(false);
                    Stats.history.setChecked(false);
                    Stats.investigation.setChecked(false);
                    Stats.nature.setChecked(false);
                    Stats.religion.setChecked(false);
                    Stats.animal.setChecked(false);
                    Stats.insight.setChecked(false);
                    Stats.medicine.setChecked(false);
                    Stats.perception.setChecked(false);
                    Stats.survival.setChecked(false);
                    Stats.deception.setChecked(false);
                    Stats.intimidation.setChecked(false);
                    Stats.performance.setChecked(false);
                    Stats.persuasion.setChecked(false);

                Notes.notes.setText("");

                load.setSelection(0);

                Toast.makeText(getBaseContext(), "Cleared text",Toast.LENGTH_SHORT).show();


            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Deleted: "+ namesList.get(spin).toString(),Toast.LENGTH_SHORT).show();
                namesList.remove(spin);
                jsonText = gson.toJson(namesList);
                PreferenceData.saveData(getBaseContext(),defName,JtoGText,jsonText);
                load.setSelection(0);
                clear.callOnClick();


            }
        });

        load.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spin = position;

                jsonText = PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(),JtoGText,"");

                name.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Name, name.getText().toString()));
                cclass.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Class, cclass.getText().toString()));
                exp.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Exp, exp.getText().toString()));
                hp.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), HP, hp.getText().toString()));
                hpm.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), HPM, hpm.getText().toString()));
                armor.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Armor, armor.getText().toString()));
                init.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Initiative, init.getText().toString()));
                speed.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Speed, speed.getText().toString()));
                level.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Level, level.getText().toString()));
                proficiency.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Proficiency, proficiency.getText().toString()));

                Notes.notes.setText(PreferenceData.loadData(getBaseContext(),parent.getItemAtPosition(position).toString(), Note, Notes.notes.getText().toString()));

                Stats.strengthEdit.setText(PreferenceData.loadData(getBaseContext(), name.getText().toString(), Str, Stats.strengthEdit.getText().toString()));
                Stats.dexterityEdit.setText(PreferenceData.loadData(getBaseContext(), name.getText().toString(), Dex, Stats.dexterityEdit.getText().toString()));
                Stats.constitutionEdit.setText(PreferenceData.loadData(getBaseContext(), name.getText().toString(), Con, Stats.constitutionEdit.getText().toString()));
                Stats.intelligenceEdit.setText(PreferenceData.loadData(getBaseContext(), name.getText().toString(), Int, Stats.intelligenceEdit.getText().toString()));
                Stats.wisdomEdit.setText(PreferenceData.loadData(getBaseContext(), name.getText().toString(), Wis, Stats.wisdomEdit.getText().toString()));
                Stats.charismaEdit.setText(PreferenceData.loadData(getBaseContext(), name.getText().toString(), Chr, Stats.charismaEdit.getText().toString()));

                Stats.strSave.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), strsave,Stats.strSave.isChecked()));
                Stats.athletics.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), athletics,Stats.athletics.isChecked()));

                Stats.dexSave.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), dexsave,Stats.dexSave.isChecked()));
                Stats.acrobatics.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), acrobatics,Stats.acrobatics.isChecked()));
                Stats.sleight.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), sleight,Stats.sleight.isChecked()));
                Stats.stealth.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), stealth,Stats.stealth.isChecked()));

                Stats.conSave.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), consave,Stats.conSave.isChecked()));

                Stats.intSave.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), intsave,Stats.intSave.isChecked()));
                Stats.arcana.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), arcana,Stats.arcana.isChecked()));
                Stats.history.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), history,Stats.history.isChecked()));
                Stats.investigation.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), investigation,Stats.investigation.isChecked()));
                Stats.nature.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), nature,Stats.nature.isChecked()));
                Stats.religion.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), religion,Stats.religion.isChecked()));

                Stats.wisSave.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), wissave,Stats.wisSave.isChecked()));
                Stats.animal.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), animal,Stats.animal.isChecked()));
                Stats.insight.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), insight,Stats.insight.isChecked()));
                Stats.medicine.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), medicine,Stats.medicine.isChecked()));
                Stats.perception.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), perception,Stats.perception.isChecked()));
                Stats.survival.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), survival,Stats.survival.isChecked()));

                Stats.chrSave.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), chrsave,Stats.chrSave.isChecked()));
                Stats.deception.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), deception,Stats.deception.isChecked()));
                Stats.intimidation.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), intimidation,Stats.intimidation.isChecked()));
                Stats.performance.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), performance,Stats.performance.isChecked()));
                Stats.persuasion.setChecked(PreferenceData.loadChecks(getBaseContext(), name.getText().toString(), persuasion,Stats.persuasion.isChecked()));

                Spells.spinner.setSelection(PreferenceData.loadSpinner(getBaseContext(),parent.getItemAtPosition(position).toString(),spinLoc,Spells.spinPosition));


                //Toast.makeText(getBaseContext(), "Loaded: " + name.getText().toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



}
