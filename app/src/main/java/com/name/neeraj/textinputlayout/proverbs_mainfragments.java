package com.name.neeraj.textinputlayout;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class proverbs_mainfragments extends AppCompatActivity {

    private ViewPager mPager1;
    private int[] layouts1={R.layout.fragment_proverbs_1,R.layout.fragment_proverbs_2,R.layout.fragment_proverbs_3,R.layout.fragment_proverbs_4,R.layout.fragment_proverbs_5,
            R.layout.fragment_proverbs_6,R.layout.fragment_proverbs_7,R.layout.fragment_proverbs_8,R.layout.fragment_proverbs_9,R.layout.fragment_proverbs_10};
    private ImageAdapter_proverbs_1_fragments mImageAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverbs_mainfragments);

        setTitle("PROVERBS");

        mPager1=(ViewPager)findViewById(R.id.viewpager1);
        mImageAdapter1=new ImageAdapter_proverbs_1_fragments(layouts1,this);
        mPager1.setAdapter(mImageAdapter1);
    }
}
