package com.name.neeraj.textinputlayout;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class confused_mainfragments extends AppCompatActivity {

    private ViewPager mPager1;
    private int[] layouts1={R.layout.fragment_confused_1_advice,R.layout.fragment_confused_1_affect,R.layout.fragment_confused_1_breath,R.layout.fragment_confused_1_capital,R.layout.fragment_confused_1_compliment,
            R.layout.fragment_confused_1_disinterested,R.layout.fragment_confused_1_flaunt,R.layout.fragment_confused_1_imply,R.layout.fragment_confused_1_lay,R.layout.fragment_confused_1_stationary};
    private ImageAdapter_confused_1_fragments mImageAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confused_mainfragments);

        setTitle("CONFUSED WORDS");

        mPager1=(ViewPager)findViewById(R.id.viewpager1);
        mImageAdapter1=new ImageAdapter_confused_1_fragments(layouts1,this);
        mPager1.setAdapter(mImageAdapter1);
    }
}
