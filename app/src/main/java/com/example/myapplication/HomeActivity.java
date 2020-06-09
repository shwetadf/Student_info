package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView Enter_name,Enter_surname,Enter_class,Enter_roll_number,Enter_grade,Enter_contact_number;
    Button back;
    String s1,s2,s3,s4,s5,s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Enter_name=(TextView)findViewById(R.id.enter_name);
        Enter_surname=(TextView)findViewById(R.id.enter_surname);
        Enter_class=(TextView)findViewById(R.id.enter_class);
        Enter_roll_number=(TextView)findViewById(R.id.enter_roll_number);
        Enter_grade=(TextView)findViewById(R.id.enter_grade);
        Enter_contact_number=(TextView)findViewById(R.id.enter_contact_number);
        s1=getIntent().getStringExtra("name");
        s2=getIntent().getStringExtra("surname");
        s3=getIntent().getStringExtra("class");
        s5=getIntent().getStringExtra("roll");
        s4=getIntent().getStringExtra("grade");
        s6=getIntent().getStringExtra("contact");
        Enter_name.setText(s1);
        Enter_surname.setText(s2);
        Enter_class.setText(s3);
        Enter_roll_number.setText(s5);
        Enter_grade.setText(s4);
        Enter_contact_number.setText(s6);
        back=(Button)findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,RcyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}