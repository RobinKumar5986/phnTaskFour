package com.example.phntaskfour;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {
    EditText Name;
    EditText email;
    EditText phone;
    Button save;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        save=findViewById(R.id.btnSave1);
        Name=findViewById(R.id.txtName);
        email=findViewById(R.id.txtEmail);
        phone=findViewById(R.id.txtPhone);

        dataHolder holder=new dataHolder();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName=Name.getText()+"";
                String newEmail=email.getText()+"";
                String newPhone=phone.getText()+"";
                if(!newName.equals("") && !newEmail.equals("") && !newPhone.equals("") && newPhone.length()>=10) {
                    newPhone="+91 " +newPhone;
                    holder.setData(newName,newEmail,newPhone);
                    Toast.makeText(addActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(addActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(addActivity.this, "Data is Missing", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}