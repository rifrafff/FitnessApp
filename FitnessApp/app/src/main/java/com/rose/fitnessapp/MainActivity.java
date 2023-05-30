package com.rose.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText txtemail,txtsifre;
    private Button btnkayit,btngiris;
    private String email,sifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtemail=findViewById(R.id.txtEmail);
        txtsifre=findViewById(R.id.txtPassword1);
        btnkayit=findViewById(R.id.btnRegister);
        btngiris=findViewById(R.id.btnLogin);
        mAuth=FirebaseAuth.getInstance();

        btnkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=txtemail.getText().toString();
                sifre=txtsifre.getText().toString();
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(sifre)){
                    mAuth.createUserWithEmailAndPassword(email,sifre)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, "Kayıt yapıldı", Toast.LENGTH_SHORT).show();
                                        txtemail.setText("");
                                        txtsifre.setText("");
                                    }else{
                                        Toast.makeText(MainActivity.this, "Sifre En Az 6 Karakter İçermelidir", Toast.LENGTH_SHORT).show();
                                    }
                                    }
                            });
                }else{
                    Toast.makeText(MainActivity.this, "E-mail ve Şifre Boş Olamaz!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=txtemail.getText().toString();
                sifre=txtsifre.getText().toString();
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(sifre)){
                    mAuth.signInWithEmailAndPassword(email,sifre)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                                        finish();
                                    }else{
                                        Toast.makeText(MainActivity.this, "E-mail ya da Şifre Hatalı", Toast.LENGTH_SHORT).show();
                                    }
                                    }
                            });
                }else{
                    Toast.makeText(MainActivity.this, "E-mail ve Şifre Boş Olamaz!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}