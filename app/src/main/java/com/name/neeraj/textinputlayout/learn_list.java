package com.name.neeraj.textinputlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class learn_list extends AppCompatActivity {
    ListView lt;
    FrameLayout puerile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_list);

        getSupportActionBar().setTitle("Advanced words");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lt = findViewById(R.id.words_listview);
        //puerile = (FrameLayout)findViewById(R.id.fragment_container);

        final String[] words = {"Puerile", "Verbose", "Acumen", "Accrue", "Abridged", "Abscond", "Apocalypse", "Servile", "Jocund", "Temporizing", "Efface", "Berserk", "Fiasco"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, words);
        lt.setAdapter(adapter);

        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final String itemname= words[i];
                switch (itemname) {
                    case "Puerile":
                        PuerileFragment fragment =   PuerileFragment.newInstance();
                      //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment).commit();
                        /*FragmentManager fragmentManager = getSupportFragmentManager();
                       FragmentTransaction transaction = fragmentManager.beginTransaction();

                        transaction.addToBackStack(null);
                        transaction.add(R.id.fragment_container,fragment,"Puerile").commit();*/
                        break;
                    case "Verbose":
                        VerboseFragment fragment1 =   VerboseFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment1).commit();
                        break;
                    case "Acumen":
                        AcumenFragment fragment2 =   AcumenFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment2).commit();
                        break;
                    case "Accrue":
                        AccrueFragment fragment3 =   AccrueFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment3).commit();
                        break;
                    case "Abridged":
                        AbridgedFragment fragment4 =   AbridgedFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment4).commit();
                        break;
                    case "Abscond":
                        AbscondFragment fragment5 =  AbscondFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment5).commit();
                        break;
                    case "Apocalypse":
                        ApocalypseFragment fragment6 =   ApocalypseFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment6).commit();
                        break;
                    case "Servile":
                       ServileFragment fragment7 =  ServileFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment7).commit();
                        break;
                    case "Jocund":
                        JocundFragment fragment8 =   JocundFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment8).commit();
                        break;
                    case "Temporizing":
                        TemporizingFragment fragment9 =  TemporizingFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment9).commit();
                        break;
                    case "Efface":
                        EffaceFragment fragment10 =   EffaceFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment10).commit();
                        break;
                    case "Berserk":
                        BerserkFragment fragment11 =   BerserkFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment11).commit();
                        break;
                    case "Fiasco":
                       FiascoFragment fragment12 =   FiascoFragment.newInstance();
                        //  ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, fragment12).commit();
                        break;
                }
            }
        });
    }
}
