package com.name.neeraj.textinputlayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Neeraj on 31-08-2018.
 */

public class ImageAdapter_prepositions_1_fragments extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private int[] layouts1={R.layout.random1preposition,R.layout.random2preposition,R.layout.random3preposition,R.layout.random4preposition,R.layout.random5preposition,
            R.layout.random6preposition,R.layout.random7preposition,R.layout.random8preposition,R.layout.random9preposition,R.layout.random10preposition};
    private Context context;

    public ImageAdapter_prepositions_1_fragments(int[] layouts1, Context context)
    {
        this.layouts1=layouts1;
        this.context=context;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return layouts1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= layoutInflater.inflate(layouts1[position],container,false);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=(View)object;
        container.removeView(view);
    }
}
