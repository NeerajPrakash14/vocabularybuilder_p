package com.name.neeraj.textinputlayout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class login extends AppCompatActivity {

    private long backpressedtime=0;

    private static final String TAG = "Login";
    private static final String EMAIL_ID = "Email_id";
    private static final String PASSWORD= "Password";
    public static final String EMAIL_IDPASS= "com.example.application.example.EXTRA_IDPASS";
    public static final String PASSWORDPASS= "com.example.application.example.PASSWORDPASS";
    public static final String DOCUMENTID= "com.example.application.example.DOCUMENTID";

    private FirebaseFirestore db1=FirebaseFirestore.getInstance();
    private CollectionReference notebookRef=db1.collection("Notebook");
    private DocumentReference noteRef=db1.document("Notebook/My First Note");


    TextInputLayout text_email,text_password;
    Button login;
    TextView create,textView;
    ProgressDialog mprogressbar;

private FirebaseFirestore db=FirebaseFirestore.getInstance();

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("VOCABULARY BUILDER");

        //mprogressbar=findViewById(R.id.progressBar);
        text_email=findViewById(R.id.text_email);
        text_password=findViewById(R.id.text_password);
        login=findViewById(R.id.login);
        create=findViewById(R.id.create);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = text_email.getEditText().getText().toString();
                final String password = text_password.getEditText().getText().toString();
                if (email.equals("")|| password.equals("")) {
                    Toast.makeText(login.this, "Please fill the mandatory fields", Toast.LENGTH_LONG).show();
                } else {
                    mprogressbar=new ProgressDialog(com.name.neeraj.textinputlayout.login.this);
                    mprogressbar.setMessage("Logging in");
                    mprogressbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mprogressbar.setIndeterminate(true);
                    mprogressbar.setProgress(50);
                    mprogressbar.show();
                    notebookRef.whereEqualTo("Email_id",email)
                            .get()
                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                 String password_db="";
                                 String Id="";
                                    for(QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots) {
                                        Note note = documentSnapshot.toObject(Note.class);
                                        note.setDocumentId(documentSnapshot.getId());
                                       // String name = note.getUsername();
                                        //email = note.getEmailId();
                                        Id=note.getDocumentId();
                                        password_db=note.getPassword();

                                    }
                                    if(password.equals(password_db)){
                                        mprogressbar.dismiss();
                                        Intent intent = new Intent(login.this, listview.class);
                                        intent.putExtra(EMAIL_IDPASS,email);
                                        intent.putExtra(PASSWORDPASS,password);
                                        intent.putExtra(DOCUMENTID,Id);
                                        startActivityForResult(intent,1);
                                    }
                                    else{
                                        mprogressbar.dismiss();
                                        Toast.makeText(login.this,"PASSWORD UNMATCHED",Toast.LENGTH_LONG).show();
                                    }

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(login.this,"Not retrived",Toast.LENGTH_LONG).show();
                                }
                            });
                    /*Intent intent = new Intent(login.this, listview.class);
                    intent.putExtra(EMAIL_IDPASS,email);
                    intent.putExtra(PASSWORDPASS,password);
                    startActivity(intent);*/
                }
            }
        });
        String signup="Don't have an account? Create Account";
        SpannableString ss=new SpannableString(signup);
       // SpannableStringBuilder ssb=new SpannableStringBuilder(ss);
        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this,MainActivity.class);
                startActivityForResult(intent,1);
            }
        };
        ss.setSpan(clickableSpan1,22,37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        create.setText(ss);
        create.setMovementMethod(LinkMovementMethod.getInstance());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(backpressedtime+4000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else{
            Toast.makeText(getBaseContext(),"Press Back again to exit",Toast.LENGTH_SHORT).show();
        }
        backpressedtime=System.currentTimeMillis();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==Activity.RESULT_OK){
                String result=data.getStringExtra("result");
            }
            if(resultCode==Activity.RESULT_CANCELED){
                Toast.makeText(login.this,"Successfully logged out",Toast.LENGTH_SHORT).show();
            }
        }
        /*if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                String text1="Please enter the login credentials";
                textView.setText(text1);
            }
            if(resultCode==RESULT_CANCELED)
            {
                textView.setText("Nothing selected");
            }
        }*/
    }
}
