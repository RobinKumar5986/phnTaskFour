package com.example.phntaskfour;

import android.widget.Toast;

import androidx.collection.ArraySet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dataHolder {
    private static  List<String> name = new ArrayList<>();
    private static  List<String> email = new ArrayList<>();
    private static  List<String> number = new ArrayList<>();

    private static boolean setOnce=false;
    public dataHolder(){
        if(setOnce==false){
            //---default names---//
            name.add("John");
            name.add("Emma");
            name.add("Michael");
            name.add("Sophia");
            name.add("David");
            name.add("Olivia");
            name.add("Daniel");
            name.add("Ava");
            name.add("William");
            name.add("Mia");
            //---default emails---//
            email.add("user1@example.com");
            email.add("user2@gmail.com");
            email.add("user3@hotmail.com");
            email.add("user4@yahoo.com");
            email.add("user5@outlook.com");
            email.add("user6@live.com");
            email.add("user7@aol.com");
            email.add("user8@icloud.com");
            email.add("user9@protonmail.com");
            email.add("user10@mail.com");
            //---default phone number---//
            number.add("+91 1234567890");
            number.add("+91 9876543210");
            number.add("+91 9988776655");
            number.add("+91 1122334455");
            number.add("+91 9876543210");
            number.add("+91 9998887776");
            number.add("+91 8887776665");
            number.add("+91 6665554443");
            number.add("+91 5554443332");
            number.add("+91 4443332221");
        }
        setOnce=true;
    }
    public void  setData(String newName ,String newEmail,String newNumber){
        name.add(newName);
        email.add(newEmail);
        number.add(newNumber);
    }
    public boolean delete(String newName){
        int  ind =name.indexOf(newName);
        if(ind!=-1){
            name.remove(ind);
            email.remove(ind);
            number.remove(ind);
            return  true;
        }else{
            return false;
        }
    }
    public String getName(int ind){
        return name.get(ind);
    }
    public String getEmail(int ind){
        return email.get(ind);
    }public String getPhone(int ind){
        return number.get(ind);
    }


    public List<String> getData(){
        return name;
    }
    public List<String> getEmailData(){
        return email;
    }
    public List<String> getNumberData(){return number; }
}
