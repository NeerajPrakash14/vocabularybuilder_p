package com.name.neeraj.textinputlayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Neeraj on 31-08-2018.
 */

public class ImageAdapter_confused_1_fragments extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private int[] layouts1={R.layout.fragment_confused_1_advice,R.layout.fragment_confused_1_affect,R.layout.fragment_confused_1_breath,R.layout.fragment_confused_1_capital,R.layout.fragment_confused_1_compliment,
            R.layout.fragment_confused_1_disinterested,R.layout.fragment_confused_1_flaunt,R.layout.fragment_confused_1_imply,R.layout.fragment_confused_1_lay,R.layout.fragment_confused_1_stationary};
    private Context context;

    public ImageAdapter_confused_1_fragments(int[] layouts1, Context context)
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
