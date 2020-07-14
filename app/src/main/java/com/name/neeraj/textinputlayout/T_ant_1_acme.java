package com.name.neeraj.textinputlayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class T_ant_1_acme extends Fragment {
    TextView question;
    RadioGroup rg;
    RadioButton option1, option2, option3, option4;
    Button next, previous;
    String text4;
    int count = 0;
    String qn1,choose1;

    public static T_ant_1_acme newInstance() {
        T_ant_1_acme fragment = new T_ant_1_acme();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_t_ant_1_acme, container, false);

        rg = v.findViewById(R.id.rg);
        next = v.findViewById(R.id.next);
        question=v.findViewById(R.id.qn);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = getView().findViewById(i);
                // choose1=i.getText
                choose1=rb.getText().toString();
                option1 = getView().findViewById(R.id.option1);
                option2 = getView().findViewById(R.id.option2);
                option3 = getView().findViewById(R.id.option3);
                option4 = getView().findViewById(R.id.option4);

                if (rb== option1 || rb==option3 || rb == option4) {
                    text4 = "wrong";

                }
                else {
                    text4 = "Correct";
                    count++;
                }
            }
        });

        qn1=question.getText().toString();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FragmentTransaction transection=getFragmentManager().beginTransaction();
                T_ant_1_acumen mfragment=new T_ant_1_acumen();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",count);
                bundle.putString("choose1",choose1);
                bundle.putString("question1",qn1);
                mfragment.setArguments(bundle);
                transection.replace(R.id.container1, mfragment);
                transection.commit();
            }

        });
        return v;

    }
}
