package com.name.neeraj.textinputlayout;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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

public class TestMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,changepassword_dialog.changepassword_dialogListener {


    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference notebookRef=db.collection("Notebook");

    String passwordretrived;

    TextView username,useremail,text;

    Button fillblanks_bt,synonyms_bt,antonynms_bt,idioms_bt;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);

        setTitle("TEST");

        Intent intent=getIntent();
        passwordretrived=intent.getStringExtra(listview.EXTRA_PASSWORDRETRIVED);
        String email1=intent.getStringExtra(listview.EXTRA_EMAIL_ID);

        fillblanks_bt=findViewById(R.id.fillblanks_bt);
        synonyms_bt=findViewById(R.id.synonyms_bt);
        antonynms_bt=findViewById(R.id.antonynms_bt);
        //idioms_bt=findViewById(R.id.idioms_bt);


        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer=findViewById(R.id.drawerlayout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        View headView=navigationView.getHeaderView(0);
        username=headView.findViewById(R.id.username);
        useremail=headView.findViewById(R.id.useremail);
        useremail.setText(email1);
        text=findViewById(R.id.text1);
        notebookRef.whereEqualTo("Email_id",email1)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        String data="";
                        String name="";



                        for(QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots) {
                            Note note = documentSnapshot.toObject(Note.class);
                            note.setDocumentId(documentSnapshot.getId());
                            name = note.getUsername();
                            passwordretrived=note.getPassword();

                            data+= name;
                            //data1+="Email:"+ email;
                        }
                        username.setText(data);
                        //useremail.setText(data1);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(TestMain.this,"not retrived",Toast.LENGTH_LONG).show();
                    }
                });


        fillblanks_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestMain.this,fillblanks_test_Main.class);
                startActivity(intent);
               // tfaghastFragment fragment =  tfaghastFragment.newInstance();
                //getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container1,fragment).commit();
            }
        });

        antonynms_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestMain.this,antonyms_test_Main.class);
                startActivity(intent);

            }
        });
        synonyms_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(TestMain.this,synonyms_test_Main.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.nav_words:
                Intent intent=new Intent(TestMain.this,learn.class);
                startActivity(intent);
                break;
            case R.id.nav_test:
                Intent intent1=new Intent(TestMain.this,TestMain.class);
                startActivity(intent1);
                break;
            case R.id.nav_proverbs:
                Intent intent3=new Intent(TestMain.this,proverbs_mainfragments.class);
                startActivity(intent3);
                break;
            case R.id.nav_confused_words:
                Intent intent4=new Intent(TestMain.this,confused_mainfragments.class);
                startActivity(intent4);
                break;
            case R.id.nav_profile:
                //Intent intent5=new Intent(TestMain.this,profile.class);
                //startActivity(intent5);
                Toast.makeText(TestMain.this, "Will be updated soon", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_change_password:
                changepassword_dialog dialog=new changepassword_dialog();
                dialog.show(getSupportFragmentManager(),"changepassword dialog");
                break;
            case R.id.nav_logout:
                //Intent intent6 =new Intent(TestMain.this,login.class);
                //startActivity(intent6);
                Intent returnIntent=new Intent();
                setResult(Activity.RESULT_CANCELED,returnIntent);
                finish();
                break;
            case R.id.nav_more:
                Intent intent7 =new Intent(TestMain.this,more_drawerActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_share:
                Intent intent8= new Intent(Intent.ACTION_SEND);
                intent8.setType("text/plain");
                String shareSubject="www.google.com";
                String shareBody="hai how are you and how old are you";
                intent8.putExtra(Intent.EXTRA_TEXT,shareBody);
                intent8.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
                startActivity(Intent.createChooser(intent8,"Share Using"));
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void applyTexts(String oldpassword1, String newpassword1) {
        Intent intent=getIntent();
        String email1=intent.getStringExtra(login.EMAIL_IDPASS);
        String Id=intent.getStringExtra(login.DOCUMENTID);

        //text.setText(email1);
        DocumentReference noteRef=db.collection("Notebook").document(Id);
        if(oldpassword1.equals(passwordretrived)){
            noteRef.update("Password",newpassword1)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(TestMain.this,"Password successfully changed",Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TestMain.this,"Unsuccessful",Toast.LENGTH_LONG).show();
                        }
                    });

        }
        else{
            Toast.makeText(TestMain.this,"Wrong old password",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        super.onBackPressed();
    }

}
