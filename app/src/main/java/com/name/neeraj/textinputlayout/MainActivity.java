package com.name.neeraj.textinputlayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Signin";
    private static final String EMAIL_ID = "Email_id";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    // "(?=\\S+$)" +           //no white spaces
                    // ".{4,}" +               //at least 4 characters
                    "$");

    private TextInputLayout textemail, textusername, textpassword, confirmpassword;
    Button confirm;
    TextView textView;
    ProgressDialog mprogressbar;


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Notebook");
    private DocumentReference noteRef = db.document("Notebook/My First Note");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("SIGN IN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textemail = findViewById(R.id.text_email);
        textusername = findViewById(R.id.text_username);
        textpassword = findViewById(R.id.text_password);
        confirmpassword = findViewById(R.id.text_password1);
        textView = findViewById(R.id.textView1);
        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = textpassword.getEditText().getText().toString();
                String text2 = confirmpassword.getEditText().getText().toString();
                String username = textusername.getEditText().getText().toString();
                String email = textemail.getEditText().getText().toString();
                if (validateEmail() | validateUsername() | validatePassword()) {

                /*String input = "Email: " + textemail.getEditText().getText().toString();
                input += "\n";
                input += "Username: " + textusername.getEditText().getText().toString();
                input += "\n";
                input += "Password: " + textpassword.getEditText().getText().toString();

                Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();*/

                    if (text1.equals(text2)) {

                        mprogressbar = new ProgressDialog(com.name.neeraj.textinputlayout.MainActivity.this);
                        mprogressbar.setMessage("Creating account");
                        mprogressbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        mprogressbar.setIndeterminate(true);
                        mprogressbar.setProgress(50);
                        mprogressbar.show();

                        Map<String, Object> note = new HashMap<>();
                        note.put(USERNAME, username);
                        note.put(EMAIL_ID, email);
                        note.put(PASSWORD, text2);

                        notebookRef.add(note)
                                //db.collection("Notebook").document("My First Note").set(note)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        mprogressbar.dismiss();
                                        Toast.makeText(MainActivity.this, "Account Created", Toast.LENGTH_LONG).show();
                                        Intent resultintent = new Intent();
                                        setResult(RESULT_OK, resultintent);
                                        finish();

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        mprogressbar.dismiss();
                                        Toast.makeText(MainActivity.this, "Account not Created", Toast.LENGTH_LONG).show();

                                    }
                                });
                        //Intent intent = new Intent(MainActivity.this, login.class);
                        //startActivity(intent);
                    } else {
                        textView.setText("Passwords not matched");
                    }
                }
            }
        });
    }

    private boolean validateEmail() {
        String emailInput = textemail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            textemail.setError("Field can't be empty");
            return false;
        } else if (Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textemail.setError("Please enter a valid email address");
            return false;
        } else {
            textemail.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String username = textusername.getEditText().getText().toString().trim();
        if (username.isEmpty()) {
            textusername.setError("Field can't be empty");
            return false;
        } else if (username.length() > 15) {
            textusername.setError("User name too long");
            return false;
        } else {
            textusername.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordinput = textpassword.getEditText().getText().toString().trim();
        if (passwordinput.isEmpty()) {
            textpassword.setError("Field can't be empty");
            confirmpassword.setError("Field can't be empty");
            return false;
        } /*else if(!PASSWORD_PATTERN.matcher(passwordinput).matches()){
            textpassword.setError("Password too weak");
            return false;}*/ else {
            textpassword.setError(null);
            confirmpassword.setError(null);
            return true;
        }
    }
   /* public void confirmInput(View v) {
        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }

        String input = "Email: " + textemail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textusername.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textpassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }*/
}
