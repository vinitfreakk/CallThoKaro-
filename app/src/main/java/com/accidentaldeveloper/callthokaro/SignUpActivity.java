package com.accidentaldeveloper.callthokaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {
    EditText emailbox1,passwordbox1,namebox;
    Button loginbtn1,createbtn1;
    FirebaseAuth auth;
    FirebaseFirestore database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        database=FirebaseFirestore.getInstance();
        emailbox1=findViewById(R.id.emailbox1);
        namebox=findViewById(R.id.namebox);
        passwordbox1=findViewById(R.id.passwordbox1);
        loginbtn1=findViewById(R.id.loginbtn1);
        createbtn1=findViewById(R.id.creatbtn1);
        createbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,password,name;
                email = emailbox1.getText().toString();
                password=passwordbox1.getText().toString();
                name=namebox.getText().toString();
                User user = new User();
                user.setEmail(email);
                user.setName(name);
                user.setPassword(password);
                //after storing user details in User model class refer the below code
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            database.collection("Users").document().set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                          startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                                }
                            });
                            Toast.makeText(SignUpActivity.this, "Account Created Successfully!!!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(SignUpActivity.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });





    }
}