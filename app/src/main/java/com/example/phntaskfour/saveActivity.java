package com.example.phntaskfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class saveActivity extends AppCompatActivity {
    EditText fileName;
    Button saveIng;
    private static final int PERMISSION_REQUEST_CODE = 1;
    public static boolean flag=false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        fileName=findViewById(R.id.txtSaveing);
        saveIng=findViewById(R.id.btnSaving);



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        } else {
            flag=true;
        }



        saveIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    String fName=fileName.getText()+"";
                    if(!fName.equals("")) {
                        createAndSaveCSV(fName);
                    }
                }else{
                    Toast.makeText(saveActivity.this, "Permission is not Granted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                flag=true;
            } else {
                // Permission denied
                Toast.makeText(this, "Write External Storage permission denied",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    //-----saving file-------//
    private void createAndSaveCSV(String fName) {
        dataHolder holder=new dataHolder();
        List<String> column1 = holder.getData();
        List<String> column2 = holder.getEmailData();
        List<String> column3 = holder.getNumberData();

        // Create a list of rows
        List<List<String>> rows = new ArrayList<>();
        for (int i = 0; i < column1.size(); i++) {
            List<String> row = new ArrayList<>();
            row.add(column1.get(i));
            row.add(String.valueOf(column2.get(i)));
            row.add(column3.get(i));
            rows.add(row);
        }

        StringBuilder csvContent = new StringBuilder();
        for (List<String> row : rows) {
            csvContent.append(String.join(",", row));
            csvContent.append("\n");
        }
        String filePath = fName+".csv";

        // Save the CSV file to internal storage
        try {
            FileOutputStream outputStream = openFileOutput(filePath, Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(csvContent.toString());
            writer.close();
            outputStream.close();
            Toast.makeText(this, "CSV file created and saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error creating CSV file", Toast.LENGTH_SHORT).show();
        }
    }

}