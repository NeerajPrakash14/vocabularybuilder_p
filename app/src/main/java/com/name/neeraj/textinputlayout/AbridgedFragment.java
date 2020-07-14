package com.name.neeraj.textinputlayout;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AbridgedFragment extends Fragment {


    public static AbridgedFragment newInstance() {
        AbridgedFragment fragment = new AbridgedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_abridged, container, false);
        if(getArguments()!=null) {

        }
        return v;
        }
    }

