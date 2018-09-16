package com.example.ashutosh.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ename, eproff;
    TextView tname, tproff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise variables from respective id defined in activity_main.xml
        ename = (EditText) findViewById(R.id.ename);
        eproff = (EditText) findViewById(R.id.eprofession);

        tname = (TextView) findViewById(R.id.txtname);
        tproff = (TextView) findViewById(R.id.txtprofession);
    }
    public void saveAccountData(View view)
    {
            //create SharedPreferences object
            SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE); //getPreferences() are used in case of Activity level
            //create sharedpreferences editor to write values in sharedpreferences file
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //Sharedpreferences support only primitive datatypes
            editor.putString("name", ename.getText().toString()); //values in sharedpreference file is store in key value format.
            editor.putString("profession", eproff.getText().toString());

            editor.apply(); //used to save changes in the file

    }
    public void loadAccountData(View view)
    {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE); //getPreferences() are used in case of Activity level

        String name = sharedPreferences.getString("name", "N/A"); //if the value at key is null then N/A willbe displayed

        String proff = sharedPreferences.getString("profession", "N/A");

        tname.setText(name);
        tproff.setText(proff);
    }
}
