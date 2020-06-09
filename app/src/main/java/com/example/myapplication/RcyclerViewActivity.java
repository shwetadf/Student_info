package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class RcyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    DatabaseHelper myDB;
    Adapter adapter;
    ArrayList<String>Enter_name,Enter_surname,Enter_class,Enter_roll_number,Enter_grade,Enter_contact_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcycler_view);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView2);
        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RcyclerViewActivity.this, StudentDetails.class);
                startActivity(LoginIntent);

            }
        });
        myDB= new DatabaseHelper(RcyclerViewActivity.this);
        Enter_name=new ArrayList<>();
        Enter_surname=new ArrayList<>();
        Enter_class=new ArrayList<>();
        Enter_roll_number=new ArrayList<>();
        Enter_grade= new ArrayList<>();
        Enter_contact_number=new ArrayList<>();
        display();
        adapter= new Adapter(RcyclerViewActivity.this,Enter_name,Enter_surname,Enter_class,Enter_roll_number,Enter_grade,Enter_contact_number);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RcyclerViewActivity.this));


    }
    void display()
    {
        Cursor cursor=myDB.readAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this,"No Data", Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext())
            {
                Enter_name.add(cursor.getString(0));
                Enter_surname.add(cursor.getString(1));
                Enter_class.add(cursor.getString(2));
                Enter_roll_number.add(cursor.getString(3));
                Enter_grade.add(cursor.getString(4));
                Enter_contact_number.add(cursor.getString(5));

            }
        }

}

}