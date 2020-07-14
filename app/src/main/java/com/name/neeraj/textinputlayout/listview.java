package com.name.neeraj.textinputlayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class listview extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, changepassword_dialog.changepassword_dialogListener {

    private long backpressedtime;

    private static final String TAG = "Listview";
    public static final String EXTRA_PASSWORDRETRIVED = "com.example.application.example.EXTRA_PASSWORDRETRIVED";
    public static final String EXTRA_EMAIL_ID = "com.example.application.example.EXTRA_EMAIL_ID";
    public static final String DOCUMENTID= "com.example.application.example.DOCUMENTID";

    private DrawerLayout drawer;

    Button bt_learn, bt_test, bt_confused, bt_proverbs;
    FrameLayout puerile;
    TextView username, useremail, text;

    String passwordretrived;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Notebook");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        setTitle("VOCABULARY BUILDER");

        Intent intent = getIntent();
        final String email1 = intent.getStringExtra(login.EMAIL_IDPASS);
        final String Id=intent.getStringExtra(login.DOCUMENTID);


        FrameLayout frameLayout = findViewById(R.id.container);
        AnimationDrawable animationDrawable = (AnimationDrawable) frameLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        puerile = (FrameLayout) findViewById(R.id.fragment_container);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        View headView = navigationView.getHeaderView(0);
        username = headView.findViewById(R.id.username);
        useremail = headView.findViewById(R.id.useremail);
        useremail.setText(email1);
        text = findViewById(R.id.text1);
        notebookRef.whereEqualTo("Email_id", email1)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        String data = "";
                        //final String Id = "";
                        String name = "";
                        String email = "";


                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Note note = documentSnapshot.toObject(Note.class);
                            note.setDocumentId(documentSnapshot.getId());
                            name = note.getUsername();
                            //Id=note.getDocumentId();
                            email = note.getEmailId();
                            passwordretrived = note.getPassword();

                            data += name;
                            //data1+="Email:"+ email;
                        }
                        username.setText(data);
                        //useremail.setText(data1);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(listview.this, "not retrived", Toast.LENGTH_LONG).show();
                    }
                });

        bt_learn = findViewById(R.id.bt_learn);
        bt_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listview.this, learn.class);
                intent.putExtra(EXTRA_PASSWORDRETRIVED, passwordretrived);
                intent.putExtra(EXTRA_EMAIL_ID, email1);
                intent.putExtra(DOCUMENTID,Id);
                startActivity(intent);
            }
        });
        bt_test = findViewById(R.id.bt_test);
        bt_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(listview.this, TestMain.class);
                intent.putExtra(EXTRA_EMAIL_ID, email1);
                intent.putExtra(DOCUMENTID,Id);
                startActivity(intent);
                //tfaghastFragment fragment=new tfaghastFragment();
                //getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container1, fragment).commit();
            }

        });
        bt_confused = findViewById(R.id.bt_confused);
        bt_confused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listview.this, confused_mainfragments.class);
                startActivity(intent);
            }
        });
        bt_proverbs = findViewById(R.id.bt_proverbs);
        bt_proverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listview.this, proverbs_mainfragments.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void applyTexts(String oldpassword1, String newpassword1) {
        Intent intent = getIntent();
        String email1 = intent.getStringExtra(login.EMAIL_IDPASS);
        String Id=intent.getStringExtra(login.DOCUMENTID);
        //text.setText(email1);
        DocumentReference noteRef = db.collection("Notebook").document(Id);
        if (oldpassword1.equals(passwordretrived)) {
            noteRef
                    .update("Password", newpassword1)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(listview.this, "Password successfully changed", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(listview.this, "Unsuccessful", Toast.LENGTH_LONG).show();
                        }
                    });

        } else {
            Toast.makeText(listview.this, "Wrong old password", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_words:
                Intent intent = new Intent(listview.this, learn.class);
                startActivity(intent);
                break;
            case R.id.nav_test:
                Intent intent1 = new Intent(listview.this, TestMain.class);
                startActivity(intent1);
                break;
            case R.id.nav_proverbs:
                Intent intent3 = new Intent(listview.this, proverbs_mainfragments.class);
                startActivity(intent3);
                break;
            case R.id.nav_confused_words:
                Intent intent4 = new Intent(listview.this, confused_mainfragments.class);
                startActivity(intent4);
                break;
            case R.id.nav_profile:
                /*Intent intent5=new Intent(listview.this,profile.class);
                startActivity(intent5);*/
                Toast.makeText(listview.this, "Will be updated soon", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_change_password:
                changepassword_dialog dialog = new changepassword_dialog();
                dialog.show(getSupportFragmentManager(), "changepassword dialog");
                break;
            case R.id.nav_logout:
                //Intent intent6 =new Intent(listview.this,login.class);
                // startActivity(intent6);
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
                break;
            case R.id.nav_more:
                Intent intent7 = new Intent(listview.this, more_drawerActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_share:
                Intent intent8 = new Intent(Intent.ACTION_SEND);
                intent8.setType("text/plain");
                String shareSubject = "Vocabulary Learning App";
                String shareBody = "https://play.google.com/store/apps/details?id=com.name.neeraj.vocabulary_learning";
                intent8.putExtra(Intent.EXTRA_TEXT, shareBody);
                intent8.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(intent8, "Share Using"));
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(listview.this);
            builder.setMessage("Do you want to EXIT?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setCancelable(false);
            final AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        }

    }
}
