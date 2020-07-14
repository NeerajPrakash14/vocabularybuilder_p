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


public class synonyms_1_testanswers extends Fragment {

    TextView uans1,uans2,uans3,uans4,uans5,uans6,uans7,uans8,uans9,uans10,cans1,cans2,cans3,cans4,cans5,cans6,cans7,cans8,cans9,cans10,qns1,qns2,qns3,qns4,qns5,qns6,qns7,qns8,qns9,qns10;
    RadioGroup rg;
    RadioButton option1, option2, option3, option4;
    String text4,choose1,choose2,choose3,choose4,choose5,choose6,choose7,choose8,choose9,choose10,qn1,qn2,qn3,qn4,qn5,qn6,qn7,qn8,qn9,qn10;
    int count;
    Button back_bt;


    public static synonyms_1_testanswers newInstance() {
        synonyms_1_testanswers fragment = new synonyms_1_testanswers();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_synonyms_1_testanswers, container, false);
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

        back_bt=v.findViewById(R.id.back_bt);
        back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transection=getFragmentManager().beginTransaction();
                synonyms_1_score mfragment=new synonyms_1_score();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",count);
                mfragment.setArguments(bundle);
                transection.replace(R.id.container1, mfragment);
                transection.commit();
            }
        });

        uans1=v.findViewById(R.id.uans1);
        uans2=v.findViewById(R.id.uans2);
        uans3=v.findViewById(R.id.uans3);
        uans4=v.findViewById(R.id.uans4);
        uans5=v.findViewById(R.id.uans5);
        uans6=v.findViewById(R.id.uans6);
        uans7=v.findViewById(R.id.uans7);
        uans8=v.findViewById(R.id.uans8);
        uans9=v.findViewById(R.id.uans9);
        uans10=v.findViewById(R.id.uans10);

        cans1=v.findViewById(R.id.cans1);
        cans2=v.findViewById(R.id.cans2);
        cans3=v.findViewById(R.id.cans3);
        cans4=v.findViewById(R.id.cans4);
        cans5=v.findViewById(R.id.cans5);
        cans6=v.findViewById(R.id.cans6);
        cans7=v.findViewById(R.id.cans7);
        cans8=v.findViewById(R.id.cans8);
        cans9=v.findViewById(R.id.cans9);
        cans10=v.findViewById(R.id.cans10);


        qns1=v.findViewById(R.id.qn01);
        qns2=v.findViewById(R.id.qn02);
        qns3=v.findViewById(R.id.qn03);
        qns4=v.findViewById(R.id.qn04);
        qns5=v.findViewById(R.id.qn05);
        qns6=v.findViewById(R.id.qn06);
        qns7=v.findViewById(R.id.qn07);
        qns8=v.findViewById(R.id.qn08);
        qns9=v.findViewById(R.id.qn09);
        qns10=v.findViewById(R.id.qn010);


        qns1.setText(qn1);
        qns2.setText(qn2);
        qns3.setText(qn3);
        qns4.setText(qn4);
        qns5.setText(qn5);
        qns6.setText(qn6);
        qns7.setText(qn7);
        qns8.setText(qn8);
        qns9.setText(qn9);
        qns10.setText(qn10);

        uans1.setText(choose1);
        uans2.setText(choose2);
        uans3.setText(choose3);
        uans4.setText(choose4);
        uans5.setText(choose5);
        uans6.setText(choose6);
        uans7.setText(choose7);
        uans8.setText(choose8);
        uans9.setText(choose9);
        uans10.setText(choose10);


        cans1.setText("Summit");
        cans2.setText("Intelligence");
        cans3.setText("Abbey");
        cans4.setText("Debilitate");
        cans5.setText("Gourmet");
        cans6.setText("Drunk");
        cans7.setText("Routine");
        cans8.setText("Grouchy");
        cans9.setText("Childish");
        cans10.setText("Militarist");



        /*next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                tfenervateFragment mfragment=new tfenervateFragment();
                //Bundle bundle=new Bundle();
                //bundle.putInt("countkey",count);
                //mfragment.setArguments(bundle);
                transaction.replace(R.id.container1,mfragment);
                transaction.commit();
                /*
                tfgluttonFragment fragment=tfgluttonFragment.newInstance();
                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container1, fragment).commit();

    }
        });*/
        return v;
    }

}
