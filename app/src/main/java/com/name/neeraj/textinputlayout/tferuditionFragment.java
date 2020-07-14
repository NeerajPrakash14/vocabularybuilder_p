package com.name.neeraj.textinputlayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class tferuditionFragment extends Fragment {
    TextView question;
    RadioGroup rg;
    RadioButton option1, option2, option3, option4;
    Button submit, previous;
    String text4,choose1,choose2,choose3,choose4,choose5,choose6,choose7,qn1,qn2,qn3,qn4,qn5,qn6,qn7;

    int count,temp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tferudition, container, false);
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
        choose5=String.valueOf(bundle.getString("choose5"));
        qn5=String.valueOf(bundle.getString("question5"));
        choose6=String.valueOf(bundle.getString("choose6"));
        qn6=String.valueOf(bundle.getString("question6"));
        rg = v.findViewById(R.id.rg);
        question=v.findViewById(R.id.qn);
        submit = v.findViewById(R.id.submit);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = getView().findViewById(i);
                choose7=rb.getText().toString();
                option1 = getView().findViewById(R.id.option1);
                option2 = getView().findViewById(R.id.option2);
                option3 = getView().findViewById(R.id.option3);
                option4 = getView().findViewById(R.id.option4);

                if (rb == option1 || rb == option2 || rb == option4) {
                    text4 = "Wrong";

                } else {
                    text4 = "Correct";
                    count++;
                }
            }
        });
        qn7=question.getText().toString();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                tfscoreFragment mfragment=new tfscoreFragment();
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
                bundle.putString("choose6",choose6);
                bundle.putString("question6",qn6);
                bundle.putString("choose7",choose7);
                bundle.putString("question7",qn7);
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
                tfenervateFragment fragment=new tfenervateFragment();
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





