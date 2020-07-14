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

public class T_ant_1_inebriated extends Fragment {
    TextView question,count1,disp;
    RadioGroup rg;
    RadioButton option1,option2, option3, option4;
    Button next,previous;
    String text4,choose1,choose2,choose3,choose4,choose5,choose6,qn2,qn1,qn3,qn4,qn5,qn6;
    int count,temp;

    public static T_ant_1_inebriated newInstance() {
        T_ant_1_inebriated fragment = new T_ant_1_inebriated();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_t_ant_1_inebriated, container, false);

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
       // disp=v.findViewById(R.id.dis);
        temp=count;
        question=v.findViewById(R.id.qn);
        rg=v.findViewById(R.id.rg);
        next=v.findViewById(R.id.next);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int i) {
                RadioButton rb=getView().findViewById(i);
                choose6=rb.getText().toString();
                option1=getView().findViewById(R.id.option1);
                option2=getView().findViewById(R.id.option2);
                option3=getView().findViewById(R.id.option3);
                option4=getView().findViewById(R.id.option4);

                if(rb==option1 || rb==option2 ||rb==option4) {
                    text4 = "Wrong";

                }
                else {
                    text4 = "Correct";
                    count++;
                }
            }
        });
        qn6=question.getText().toString();
        //count1=v.findViewById(R.id.count1);
        //count1.setText(""+count);
        //disp.setText(choose1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                T_ant_1_mundane mfragment=new T_ant_1_mundane();
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
                T_ant_1_glutton mfragment=new T_ant_1_glutton();
                Bundle bundle1=new Bundle();
                bundle1.putInt("countkey",temp);
                mfragment.setArguments(bundle1);
                transaction.addToBackStack(null);
                transaction.replace(R.id.container1,mfragment);
                transaction.commit();
            }
        });

        return v;
    }
}
