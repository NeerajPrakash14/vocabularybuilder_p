package com.name.neeraj.textinputlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class contactusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        setTitle("Contact options");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
