package com.example.phntaskfour;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteActivity extends AppCompatActivity {
    EditText  newName;
    Button deleteBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        deleteBtn=findViewById(R.id.secondDelete);
        newName=findViewById(R.id.deleteName);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=newName.getText()+"";
                if(!name.equals("")){
                    showAlert(name);
                }
                else{
                    Toast.makeText(deleteActivity.this, "Enter some name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showAlert(String stud) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Are You Sure to delete "+ stud+ " ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dataHolder holder=new dataHolder();
                boolean ans=holder.delete(stud);
                if(ans){
                    Toast.makeText(deleteActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(deleteActivity.this, "No sch Student...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(deleteActivity.this, "Deletion Canceled", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }
}