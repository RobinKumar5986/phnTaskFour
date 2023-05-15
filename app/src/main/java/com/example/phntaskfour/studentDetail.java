package com.example.phntaskfour;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class studentDetail extends AppCompatActivity {
    TextView name,email,phone;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        name =findViewById(R.id.textView);
        email=findViewById(R.id.textView2);
        phone=findViewById(R.id.textView4);
        Intent i=getIntent();
        int ind=i.getIntExtra("index",-1);
        dataHolder holder=new dataHolder();
        name.setText(name.getText()+" "+holder.getName(ind));
        email.setText(email.getText()+" "+holder.getEmail(ind));
        phone.setText(phone.getText()+" "+holder.getPhone(ind));
    }
}