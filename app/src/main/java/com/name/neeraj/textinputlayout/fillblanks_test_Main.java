package com.name.neeraj.textinputlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fillblanks_test_Main extends AppCompatActivity {

    Button test1,test2,test3,test4,test5,test6,test7,test8,test9,test10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillblanks_test__main);

        setTitle("TEST SERIES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        test1=findViewById(R.id.test1);

    }

    public void test_onclick(View v)
    {
        tfaghastFragment fragment =  tfaghastFragment.newInstance();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container1,fragment).commit();

    }

}
