package com.name.neeraj.textinputlayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by MADHU on 05-12-2018.
 */

public class changepassword_dialog extends AppCompatDialogFragment {

    EditText oldpassword,newpassword;
    private changepassword_dialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.fragment_changepassword_dialog,null);

        builder.setView(view)
                .setTitle("CHANGE PASSWORD")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("APPLY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String oldpassword1=oldpassword.getText().toString();
                        String newpassword1=newpassword.getText().toString();
                        listener.applyTexts(oldpassword1,newpassword1);
                    }
                });

        oldpassword=view.findViewById(R.id.oldpassword);
        newpassword=view.findViewById(R.id.newpassword);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(changepassword_dialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement changepasswordListener");
        }

    }

    public interface changepassword_dialogListener{
        void applyTexts(String oldpassword1,String newpassword1);
    }

}
