package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText login_email,login_password,login_name;
    private Button login;
    private TextView login_redirect;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();
        login_name=findViewById(R.id.login_name);
        login_email=findViewById(R.id.login_email);
        login_password=findViewById(R.id.login_password);
        login=findViewById(R.id.login);
        login_redirect=findViewById(R.id.login_redirect);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_email.getText().toString();
                String pass = login_password.getText().toString();
                String name=login_name.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                                        Bundle b=getIntent().getExtras();
//                                        String name=b.getString("name");
                                        Intent i=new Intent(Login.this, Table.class);
                                        Bundle bl=new Bundle();
                                        bl.putString("name",name);
                                        i.putExtras(bl);
                                        startActivity(i);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        login_password.setError("Password cannot be empty");
                    }
                } else if (email.isEmpty()) {
                    login_email.setError("Email cannot be empty");
                } else {
                    login_email.setError("Enter a valid email id");
                }
            }
        });
        login_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Signup.class));
            }
        });
    }
}