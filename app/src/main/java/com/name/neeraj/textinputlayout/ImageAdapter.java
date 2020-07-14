package com.name.neeraj.textinputlayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Neeraj on 31-08-2018.
 */

public class ImageAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private int[] layouts={R.layout.random1idiom,R.layout.random2idiom,R.layout.random3idiom,R.layout.random4idiom,R.layout.random5idiom,
            R.layout.random6idiom,R.layout.random7idiom,R.layout.random8idiom,R.layout.random9idiom,R.layout.random10idiom};
    private Context context;

    public ImageAdapter(int[] layouts,Context context)
    {
        this.layouts=layouts;
        this.context=context;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= layoutInflater.inflate(layouts[position],container,false);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=(View)object;
        container.removeView(view);
    }
}
