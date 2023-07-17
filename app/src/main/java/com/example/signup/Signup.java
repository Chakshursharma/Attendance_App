package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signup_email,signup_password;
    private Button signup;
    private TextView signup_redirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth=FirebaseAuth.getInstance();
        signup_email=findViewById(R.id.signup_email);
        signup_password=findViewById(R.id.signup_password);
        signup=findViewById(R.id.signup);
        signup_redirect=findViewById(R.id.signup_redirect);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=signup_email.getText().toString();
                String pass=signup_password.getText().toString();
                if (user.isEmpty()){
                    signup_email.setError("Email cannot be Empty");
                }
                if (pass.isEmpty()){
                    signup_password.setError("Password cannot be Empty");
                }
                else {
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Signup.this, "SignUP Successful", Toast.LENGTH_SHORT).show();
                                Intent i =new Intent(Signup.this, Login.class);
//                                Bundle b=new Bundle();
//                                b.putString("name",name);
//                                i.putExtras(b);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(Signup.this, "SignUP Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        signup_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this, Login.class));
                finish();
            }
        });
    }
}