package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Table extends AppCompatActivity {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    Button p1,a1,p2,a2,p3,p4,a3,a4,v1;
    TextView s1,s2,s3,s4,nametext;
    float total1,total2,total3,total4;
    float pre1=0,abs1=0,pre2=0,abs2=0,pre3=0,abs3=0,pre4=0,abs4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Bundle bl=getIntent().getExtras();
        String name=bl.getString("name");
        nametext=findViewById(R.id.name);
        nametext.setText("Welcome "+name+"!");
        nametext.setTextColor(Color.WHITE);
        s1=findViewById(R.id.att1);
        s2=findViewById(R.id.att2);
        s3=findViewById(R.id.att3);
        s4=findViewById(R.id.att4);
        p1=findViewById(R.id.Present1);
        p2=findViewById(R.id.Present2);
        p3=findViewById(R.id.Present3);
        p4=findViewById(R.id.Present4);
        a1=findViewById(R.id.Absent1);
        a2=findViewById(R.id.Absent2);
        a3=findViewById(R.id.Absent3);
        a4=findViewById(R.id.Absent4);
        p1.setOnClickListener(view -> {
            pre1++;
            total1=(float)((pre1)/(pre1+abs1))*100;
            s1.setText(String.valueOf(decfor.format(total1)));
            if(total1>85.0){
                s1.setTextColor(Color.GREEN);
            } else if (total1>60.0) {
                s1.setTextColor(Color.YELLOW);
            }
            else {
                s1.setTextColor(Color.RED);
            }
        });
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abs1++;
                total1=(float)((pre1)/(pre1+abs1))*100;
                s1.setText(String.valueOf(decfor.format(total1)));
                if(total1>85.0){
                    s1.setTextColor(Color.GREEN);
                } else if (total1>60.0) {
                    s1.setTextColor(Color.YELLOW);
                }
                else {
                    s1.setTextColor(Color.RED);
                }
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre2++;
                total2=(float)((pre2)/(pre2+abs2))*100;
                s2.setText(String.valueOf(decfor.format(total2)));
                if(total2>85.0){
                    s2.setTextColor(Color.GREEN);
                } else if (total2>60.0) {
                    s2.setTextColor(Color.YELLOW);
                }
                else {
                    s2.setTextColor(Color.RED);
                }
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abs2++;
                total2=(float)((pre2)/(pre2+abs2))*100;
                s2.setText(String.valueOf(decfor.format(total2)));
                if(total2>85.0){
                    s2.setTextColor(Color.GREEN);
                } else if (total2>60.0) {
                    s2.setTextColor(Color.YELLOW);
                }
                else {
                    s2.setTextColor(Color.RED);
                }
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre3++;
                total3=(float)((pre3)/(pre3+abs3))*100;
                s3.setText(String.valueOf(decfor.format(total3)));
                if(total3>85.0){
                    s3.setTextColor(Color.GREEN);
                } else if (total3>60.0) {
                    s3.setTextColor(Color.YELLOW);
                }
                else {
                    s3.setTextColor(Color.RED);
                }
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abs3++;
                total3=(float)((pre3)/(pre3+abs3))*100;
                s3.setText(String.valueOf(decfor.format(total3)));
                if(total3>85.0){
                    s3.setTextColor(Color.GREEN);
                } else if (total3>60.0) {
                    s3.setTextColor(Color.YELLOW);
                }
                else {
                    s3.setTextColor(Color.RED);
                }
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre4++;
                total4=(float)((pre4)/(pre4+abs4))*100;
                s4.setText(String.valueOf(decfor.format(total4)));
                if(total4>85.0){
                    s4.setTextColor(Color.GREEN);
                } else if (total4>60.0) {
                    s4.setTextColor(Color.YELLOW);
                }
                else {
                    s4.setTextColor(Color.RED);
                }
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abs4++;
                total4=(float)((pre4)/(pre4+abs4))*100;
                s4.setText(String.valueOf(decfor.format(total4)));
                if(total4>85.0){
                    s4.setTextColor(Color.GREEN);
                } else if (total4>60.0) {
                    s4.setTextColor(Color.YELLOW);
                }
                else {
                    s4.setTextColor(Color.RED);
                }
            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Table.this,MainActivity.class);
                Bundle b=new Bundle();
                b.putString("total1",(String.valueOf(total1)));
                i.putExtras(b);
                startActivity(i);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Table.this,MainActivity.class);
                Bundle b=new Bundle();
                b.putString("total1",(String.valueOf(total2)));
                i.putExtras(b);
                startActivity(i);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Table.this,MainActivity.class);
                Bundle b=new Bundle();
                b.putString("total1",(String.valueOf(total3)));
                i.putExtras(b);
                startActivity(i);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Table.this,MainActivity.class);
                Bundle b=new Bundle();
                b.putString("total1",(String.valueOf(total4)));
                i.putExtras(b);
                startActivity(i);
            }
        });

    }
}