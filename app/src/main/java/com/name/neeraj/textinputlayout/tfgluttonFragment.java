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


public class tfgluttonFragment extends Fragment {
TextView question,count1,disp;
RadioGroup rg;
RadioButton option1,option2, option3, option4;
Button next,previous;
String text4,choose1,choose2,qn2,qn1;
int count,temp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_tfglutton, container, false);

        Bundle bundle=getArguments();
       count=Integer.valueOf(bundle.getInt("countkey"));
       choose1=String.valueOf(bundle.getString("choose1"));
      // disp=v.findViewById(R.id.dis);
       qn1=String.valueOf(bundle.getString("question1"));
        temp=count;
        question=v.findViewById(R.id.qn);
        rg=v.findViewById(R.id.rg);
        next=v.findViewById(R.id.next);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int i) {
                RadioButton rb=getView().findViewById(i);
                choose2=rb.getText().toString();
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
        qn2=question.getText().toString();
        //count1=v.findViewById(R.id.count1);
        //count1.setText(""+count);
       //disp.setText(choose1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                tfpetulantFragment mfragment=new tfpetulantFragment();
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
                tfaghastFragment mfragment=new tfaghastFragment();

                transaction.replace(R.id.container1,mfragment);
                transaction.commit();
            }
        });
        return v;

        }
    }

