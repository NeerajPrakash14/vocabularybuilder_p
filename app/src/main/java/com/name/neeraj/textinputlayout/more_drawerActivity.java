package com.name.neeraj.textinputlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class more_drawerActivity extends AppCompatActivity {

    TextView acknowledgment, references, support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_drawer);

        setTitle("More options");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        acknowledgment=findViewById(R.id.aknowledgment);
        references=findViewById(R.id.references);
        support=findViewById(R.id.support);

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(more_drawerActivity.this,contactusActivity.class);
                startActivity(intent);
            }
        });

        acknowledgment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(more_drawerActivity.this,acknowledgmentActivity.class);
                startActivity(intent);
            }
        });
        references.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(more_drawerActivity.this,referencesActivity.class);
                startActivity(intent);
            }
        });
    }
}
