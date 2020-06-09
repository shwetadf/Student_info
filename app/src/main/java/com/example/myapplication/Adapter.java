package com.example.myapplication;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private Context context;
    private ArrayList Enter_name,Enter_surname,Enter_class,Enter_roll_number,Enter_grade,Enter_contact_number;
    Adapter(Context context,ArrayList Enter_name,ArrayList Enter_surname,ArrayList Enter_class,ArrayList Enter_roll_number,ArrayList Enter_grade,ArrayList Enter_contact_number)
    {
        this.context=context;
        this.Enter_name=Enter_name;
        this.Enter_surname=Enter_surname;
        this.Enter_class=Enter_class;
        this.Enter_roll_number=Enter_roll_number;
        this.Enter_grade=Enter_grade;
        this.Enter_contact_number=Enter_contact_number;

    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.item_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        holder.Enter_name.setText(String.valueOf(Enter_name.get(position)));
        holder.Enter_surname.setText(String.valueOf(Enter_surname.get(position)));
        holder.Enter_class.setText(String.valueOf(Enter_class.get(position)));
        holder.Enter_grade.setText(String.valueOf(Enter_grade.get(position)));


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"you clicked to "+String.valueOf(Enter_name.get(position)),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("name",String.valueOf(Enter_name.get(position)));
                intent.putExtra("surname",String.valueOf(Enter_surname.get(position)));
                intent.putExtra("class",String.valueOf(Enter_class.get(position)));
                intent.putExtra("roll",String.valueOf(Enter_roll_number.get(position)));
                intent.putExtra("grade",String.valueOf(Enter_grade.get(position)));
                intent.putExtra("contact",String.valueOf(Enter_contact_number.get(position)));
               context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Enter_name.size();

    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView Enter_name;
        private TextView Enter_surname;
        private TextView Enter_class;
        private TextView Enter_grade;
        private ConstraintLayout constraintLayout;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Enter_name=itemView.findViewById(R.id.Enter_Name);
            Enter_surname=itemView.findViewById(R.id.Enter_Surname);
            Enter_class=itemView.findViewById(R.id.Enter_Class);
            Enter_grade=itemView.findViewById(R.id.Enter_Grade);
            constraintLayout=itemView.findViewById(R.id.layout1);
        }
    }
}
