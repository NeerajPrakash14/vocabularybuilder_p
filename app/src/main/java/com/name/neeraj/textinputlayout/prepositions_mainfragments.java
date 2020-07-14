package com.name.neeraj.textinputlayout;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class prepositions_mainfragments extends AppCompatActivity {

    private ViewPager mPager1;
    private int[] layouts1={R.layout.random1preposition,R.layout.random2preposition,R.layout.random3preposition,R.layout.random4preposition,R.layout.random5preposition,
            R.layout.random6preposition,R.layout.random7preposition,R.layout.random8preposition,R.layout.random9preposition,R.layout.random10preposition};
    private ImageAdapter_prepositions_1_fragments mImageAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepositions_mainfragments);

        mPager1=(ViewPager)findViewById(R.id.viewpager1);
        mImageAdapter1=new ImageAdapter_prepositions_1_fragments(layouts1,this);
        mPager1.setAdapter(mImageAdapter1);
    }
}
