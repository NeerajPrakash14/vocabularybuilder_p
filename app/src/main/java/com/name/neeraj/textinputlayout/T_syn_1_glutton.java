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


public class T_syn_1_glutton extends Fragment {
    TextView question;
    RadioGroup rg;
    RadioButton option1, option2, option3, option4;
    Button next, previous;
    String text4,choose1,choose2,choose3,choose4,choose5,choose6,choose7,qn1,qn2,qn3,qn4,qn5,qn6,qn7;

    int count,temp;


    public static T_syn_1_glutton newInstance() {
        T_syn_1_glutton fragment = new T_syn_1_glutton();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_t_syn_1_glutton, container, false);

        Bundle bundle=getArguments();
        count=Integer.valueOf(bundle.getInt("countkey"));
        temp=count;
        choose1=String.valueOf(bundle.getString("choose1"));
        qn1=String.valueOf(bundle.getString("question1"));
        choose2=String.valueOf(bundle.getString("choose2"));
        qn2=String.valueOf(bundle.getString("question2"));
        choose3=String.valueOf(bundle.getString("choose3"));
        qn3=String.valueOf(bundle.getString("question3"));
        choose4=String.valueOf(bundle.getString("choose4"));
        qn4=String.valueOf(bundle.getString("question4"));
        rg = v.findViewById(R.id.rg);
        question=v.findViewById(R.id.qn);
        next = v.findViewById(R.id.next);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = getView().findViewById(i);
                choose5=rb.getText().toString();
                option1 = getView().findViewById(R.id.option1);
                option2 = getView().findViewById(R.id.option2);
                option3 = getView().findViewById(R.id.option3);
                option4 = getView().findViewById(R.id.option4);

                if (rb == option2 || rb == option3 || rb == option4) {
                    text4 = "Wrong";

                } else {
                    text4 = "Correct";
                    count++;
                }
            }
        });
        qn5=question.getText().toString();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                T_syn_1_inebriated mfragment=new T_syn_1_inebriated();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",count);
                bundle.putString("choose1",choose1);
                bundle.putString("question1",qn1);
                bundle.putString("choose2",choose2);
                bundle.putString("question2",qn2);
                bundle.putString("choose3",choose3);
                bundle.putString("question3",qn3);
                bundle.putString("choose4",choose4);
                bundle.putString("question4",qn4);
                bundle.putString("choose5",choose5);
                bundle.putString("question5",qn5);
                mfragment.setArguments(bundle);
                transaction.replace(R.id.container1,mfragment);
                transaction.commit();

            }

        });
        previous=v.findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                T_syn_1_enervate fragment=new T_syn_1_enervate();
                Bundle bundle1=new Bundle();
                bundle1.putInt("countkey",temp);
                fragment.setArguments(bundle1);
                transaction.addToBackStack(null);
                transaction.replace(R.id.container1,fragment);
                transaction.commit();
            }
        });

        return v;
    }
}
