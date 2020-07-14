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


public class T_syn_1_warmonger extends Fragment {
    TextView question,count1;
    RadioGroup rg;
    RadioButton option1,option2, option3, option4;
    Button next,previous;
    String text4,choose1,choose2,choose3,choose4,choose5,choose6,choose7,choose8,choose9,choose10,qn1,qn2,qn3,qn4,qn5,qn6,qn7,qn8,qn9,qn10;
    int count,temp;

    public static T_syn_1_warmonger newInstance() {
        T_syn_1_warmonger fragment = new T_syn_1_warmonger();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View v=inflater.inflate(R.layout.fragment_t_syn_1_warmonger, container, false);
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

        temp=count;
        question=v.findViewById(R.id.qn);
        rg=v.findViewById(R.id.rg);
        next=v.findViewById(R.id.next);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int i) {
                RadioButton rb=getView().findViewById(i);
                choose10=rb.getText().toString();
                option1=getView().findViewById(R.id.option1);
                option2=getView().findViewById(R.id.option2);
                option3=getView().findViewById(R.id.option3);
                option4=getView().findViewById(R.id.option4);

                if(rb==option2 || rb==option3 ||rb==option4) {
                    text4 = "Wrong";

                }
                else {
                    text4 = "Correct";
                    count++;
                }
            }
        });
        qn10=question.getText().toString();
        //count1=v.findViewById(R.id.count);
        //count1.setText(""+count);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                synonyms_1_score mfragment=new synonyms_1_score();
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
        previous=v.findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                T_syn_1_puerile mfragment=new T_syn_1_puerile();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",temp);

                mfragment.setArguments(bundle);
                transaction.replace(R.id.container1,mfragment);
                transaction.commit();
            }
        });

        return  v;
    }
}
