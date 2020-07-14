package com.name.neeraj.textinputlayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

public class businesswords_list extends AppCompatActivity {
    ListView lt;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesswords_list);

        getSupportActionBar().setTitle("Business words");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lt = findViewById(R.id.words_listview);
        frameLayout = (FrameLayout)findViewById(R.id.fragment_container);

        final String[] words = {"STOCK", "LUCRATIVE", "COMMODITY", "INFLATION", "MERGER", "WAGE", "BIANNUAL", "BILLBOARD", "SCARCITY", "DEFICIT"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, words);
        lt.setAdapter(adapter);

        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final String itemname= words[i];
                //AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);

                switch (itemname) {
                    case "STOCK":
                        showdialog1(itemname);

                        break;
                    case "LUCRATIVE":
                        showpopup2(itemname);
                        break;
                    case "COMMODITY":
                        showdialog3(itemname);
                        break;
                    case "INFLATION":
                        showdialog4(itemname);
                        break;
                    case "MERGER":
                        showdialog5(itemname);
                        break;
                    case "WAGE":
                        showdialog6(itemname);
                        break;
                    case "BIANNUAL":
                        showdialog7(itemname);
                        break;
                    case "BILLBOARD":
                        showdialog8(itemname);
                        break;
                    case "SCARCITY":
                        showdialog9(itemname);
                        break;
                    case "DEFICIT":
                        showdialog10(itemname);
                        break;
                }
            }
        });
    }

    public void showdialog1(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "the capital raised by a company or corporation through the issue and subscription of shares.")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showpopup2(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "Producing a lot of money; profitable")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showdialog3(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "A substance or a primary product that can be traded or brought and sold usually in large quantities")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showdialog4(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "An increase in the prices of goods and services causing a reduction in the value of money")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showdialog5(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "The joining of two or more companies to make a larger company")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showdialog6(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "is the money that someone is paid every week by their employer")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showdialog7(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                " happening twice a year")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showdialog8(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "signboard for advertising posters")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }
    public void showdialog9(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "A very small supply of resources; a lack of something")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void showdialog10(final String itemname)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(businesswords_list.this);
        builder.setMessage(itemname+":                                                   " +
                "The total amount by which money spent is more than money received.")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(businesswords_list.this,"Done :"+itemname,Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        final AlertDialog dialog= builder.create();
        dialog.show();
    }


}
