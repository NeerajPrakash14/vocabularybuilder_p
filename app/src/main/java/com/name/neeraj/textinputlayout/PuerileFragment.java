package com.name.neeraj.textinputlayout;



        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;


public class PuerileFragment extends Fragment {


    public static PuerileFragment newInstance() {
        PuerileFragment fragment = new PuerileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_puerile, container, false);


        if (getArguments() != null) {

        }



        return v;
    }
}