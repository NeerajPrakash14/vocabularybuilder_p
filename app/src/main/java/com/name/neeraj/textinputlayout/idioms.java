package com.name.neeraj.textinputlayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class idioms extends AppCompatActivity {

    private ViewPager mPager;
    private int[] layouts={R.layout.random1idiom,R.layout.random2idiom,R.layout.random3idiom,R.layout.random4idiom,R.layout.random5idiom,
            R.layout.random6idiom,R.layout.random7idiom,R.layout.random8idiom,R.layout.random9idiom,R.layout.random10idiom};
    private ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioms);

        mPager=(ViewPager)findViewById(R.id.viewpager);
        mImageAdapter=new ImageAdapter(layouts,this);
        mPager.setAdapter(mImageAdapter);
    }
}
