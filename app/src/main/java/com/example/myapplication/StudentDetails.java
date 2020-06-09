package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentDetails extends AppCompatActivity {
    EditText Enter_name,Enter_surname,Enter_class,Enter_roll_number,Enter_grade,Enter_contact_number;
    Button cancel,save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);
        Enter_name=(EditText)findViewById(R.id.enter_name);
        Enter_surname=(EditText)findViewById(R.id.enter_surname);
        Enter_class=(EditText)findViewById(R.id.enter_class);
        Enter_roll_number=(EditText)findViewById(R.id.enter_roll_number);
        Enter_grade=(EditText)findViewById(R.id.enter_grade);
        Enter_contact_number=(EditText)findViewById(R.id.enter_contact_number);
        cancel=(Button) findViewById(R.id.Cancel);
        save=(Button) findViewById(R.id.Save);
        final DatabaseHelper databaseHelper=new DatabaseHelper(this);
        cancel.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          Intent LoginIntent = new Intent(StudentDetails.this, RcyclerViewActivity.class);
                                          startActivity(LoginIntent);
                                      }
                                  });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=Enter_name.getText().toString();
                String s2=Enter_surname.getText().toString();
                String s3=Enter_class.getText().toString();
               String s4=Enter_roll_number.getText().toString();
               String s5=Enter_grade.getText().toString();
               String s6=Enter_contact_number.getText().toString();

               if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals(""))
               {
                   Toast.makeText(getApplicationContext(),"Data not inserted", Toast.LENGTH_LONG).show();

               }
               else
               {

                   boolean isInserted=databaseHelper.insert(s1,s2,s3,s4,s5,s6);
                   if (isInserted=true)
                       Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_LONG).show();

               }

               Enter_name.setText(null);
               Enter_surname.setText(null);
               Enter_class.setText(null);
               Enter_roll_number.setText(null);
               Enter_grade.setText(null);
               Enter_contact_number.setText(null);
            }
        });
    }
}