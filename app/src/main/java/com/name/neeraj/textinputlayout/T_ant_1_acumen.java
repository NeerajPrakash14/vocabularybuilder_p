package com.name.neeraj.textinputlayout;


import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class T_ant_1_acumen extends Fragment {
    TextView question;
    RadioGroup rg;
    RadioButton option1, option2, option3, option4;
    Button next, previous;
    String text4,choose1,choose2,choose3,choose4,qn1,qn2,qn3,qn4;
    int count,temp;


    public static T_ant_1_acumen newInstance() {
        T_ant_1_acumen fragment = new T_ant_1_acumen();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_t_ant_1_acumen, container, false);

        Bundle bundle=getArguments();
        count=Integer.valueOf(bundle.getInt("countkey"));
        choose1=String.valueOf(bundle.getString("choose1"));
        qn1=String.valueOf(bundle.getString("question1"));
        temp=count;
        rg = v.findViewById(R.id.rg);
        next = v.findViewById(R.id.next);
        question=v.findViewById(R.id.qn);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = getView().findViewById(i);
                choose2=rb.getText().toString();
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
        qn2=question.getText().toString();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                T_ant_1_cloister mfragment=new T_ant_1_cloister();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",count);
                bundle.putString("choose1",choose1);
                bundle.putString("question1",qn1);
                bundle.putString("choose2",choose2);
                bundle.putString("question2",qn2);
                mfragment.setArguments(bundle);
                transection.replace(R.id.container1, mfragment);
                transection.commit();


            }

        });
        previous=v.findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                T_ant_1_acme fragment=new T_ant_1_acme();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",temp);
                fragment.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.replace(R.id.container1,fragment);
                transaction.commit();
            }
        });

        return v;

    }
}
