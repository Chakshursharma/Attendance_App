package com.example.signup;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    TextView text,main;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=findViewById(R.id.progress_bar);
        pb.setProgress(0);
        main=findViewById(R.id.main_text);
        text=findViewById(R.id.attend_text);
        Bundle b=getIntent().getExtras();
        String total1=b.getString("total1");
        float tot=Float.parseFloat(total1);
        pb.setProgress((int) Float.parseFloat(total1));
        text.setText(String.valueOf(decfor.format(Float.parseFloat(total1))));
        if(tot>85.0){
            text.setTextColor(Color.GREEN);
            main.setTextColor(Color.GREEN);
            main.setText("You are regular to the Classes!");
        } else if (tot>60.0) {
            text.setTextColor(Color.YELLOW);
            main.setTextColor(Color.YELLOW);
            main.setText("You must attend the classes regularly");
        }
        else {
            text.setTextColor(Color.RED);
            main.setTextColor(Color.RED);
            main.setText("NSAR");
        }


    }

}