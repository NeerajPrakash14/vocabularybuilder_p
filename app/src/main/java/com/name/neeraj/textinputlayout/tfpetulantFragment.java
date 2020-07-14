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


public class tfpetulantFragment extends Fragment {
    TextView question,count1;
    RadioGroup rg;
    RadioButton option1,option2, option3, option4;
    Button next,previous;
    String text4,choose1,choose2,choose3,qn1,qn2,qn3;
    int count,temp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_tfpetulent, container, false);

        Bundle bundle=getArguments();
        count=Integer.valueOf(bundle.getInt("countkey"));
        choose1=String.valueOf(bundle.getString("choose1"));
        qn1=String.valueOf(bundle.getString("question1"));
        choose2=String.valueOf(bundle.getString("choose2"));
        qn2=String.valueOf(bundle.getString("question2"));
        temp=count;
        question=v.findViewById(R.id.qn);
        rg=v.findViewById(R.id.rg);
        next=v.findViewById(R.id.next);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int i) {
                RadioButton rb=getView().findViewById(i);
                choose3=rb.getText().toString();
                option1=getView().findViewById(R.id.option1);
                option2=getView().findViewById(R.id.option2);
                option3=getView().findViewById(R.id.option3);
                option4=getView().findViewById(R.id.option4);

                if(rb==option1 || rb==option2 ||rb==option3) {
                    text4 = "Wrong";

                }
                else {
                    text4 = "Correct";
                    count++;
                }
            }
        });
        qn3=question.getText().toString();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                tfagogFragment mfragment=new tfagogFragment();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",count);
                bundle.putString("choose1",choose1);
                bundle.putString("question1",qn1);
                bundle.putString("choose2",choose2);
                bundle.putString("question2",qn2);
                bundle.putString("choose3",choose3);
                bundle.putString("question3",qn3);
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
                tfgluttonFragment mfragment=new tfgluttonFragment();
                Bundle bundle=new Bundle();
                bundle.putInt("countkey",temp);

                mfragment.setArguments(bundle);
                transaction.replace(R.id.container1,mfragment);
                transaction.commit();
            }
        });
        return v;

    }
}

