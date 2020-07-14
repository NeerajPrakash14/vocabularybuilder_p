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


public class tfscoreFragment extends Fragment {
    TextView text,score,maxscore,viewanswers;
    TextView uans1,uans2,uans3,uans4,uans5,uans6,uans7,uans8,uans9,uans10,cans1,cans2,cans3,cans4,cans5,cans6,cans7,cans8,cans9,cans10,qns1,qns2,qns3,qns4,qns5,qns6,qns7,qns8,qns9,qns10;
    RadioGroup rg;
    RadioButton option1, option2, option3, option4;
    String text4,choose1,choose2,choose3,choose4,choose5,choose6,choose7,choose8,choose9,choose10,qn1,qn2,qn3,qn4,qn5,qn6,qn7,qn8,qn9,qn10;
    int count;
    Button retaketest_bt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tfscore, container, false);
        Bundle bundle=getArguments();
        count=Integer.valueOf(bundle.getInt("countkey"));
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
        choose7=String.valueOf(bundle.getString("choose7"));
        qn7=String.valueOf(bundle.getString("question7"));
        choose8=String.valueOf(bundle.getString("choose8"));
        qn8=String.valueOf(bundle.getString("question8"));
        choose9=String.valueOf(bundle.getString("choose9"));
        qn9=String.valueOf(bundle.getString("question9"));
        choose10=String.valueOf(bundle.getString("choose10"));
        qn10=String.valueOf(bundle.getString("question10"));

        score=v.findViewById(R.id.score);
        score.setText(""+count);

        retaketest_bt=v.findViewById(R.id.retaketest_bt);
        retaketest_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                tfaghastFragment mfragment=new tfaghastFragment();
                mfragment.setArguments(null);
                transection.replace(R.id.container1, mfragment);
                transection.commit();
            }
        });

        viewanswers=v.findViewById(R.id.viewanswers);
        viewanswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transection=getFragmentManager().beginTransaction();
                testanswers_displayFragment mfragment=new testanswers_displayFragment();
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
                bundle.putString("choose8",choose8);
                bundle.putString("question8",qn8);
                bundle.putString("choose9",choose9);
                bundle.putString("question9",qn9);
                bundle.putString("choose10",choose10);
                bundle.putString("question10",qn10);

                mfragment.setArguments(bundle);
                transection.replace(R.id.container1, mfragment);
                transection.commit();

            }
        });

        return v;
    }


}







